#include <ESP8266WiFi.h>
#include <DHT.h>

const char* ssid = "CHANGE_THIS";
const char* password = "CHANGE_THIS";
const char* host = "CHANGE_THIS";
const char* location = "CHANGE_THIS";
const int delayInMinutes = 10  ;

#define DHTTYPE DHT11
#define DHTPIN 2 // GPIO2

DHT dht(DHTPIN, DHTTYPE, 11);

float temperatura;
float humedad;

void setup() {
  Serial.begin(115200);
  Serial.println("Starting delay");
  delay(5000);

  dht.begin();+

  Serial.printf("Connecting to %s ", ssid);
  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
  Serial.println(" connected");
  // Serial.println("WiFi ip address: %s", WiFi.localIP());
}

void loop() {

  WiFiClient client;

  Serial.printf("\n[Connecting to %s ...", host);
  if (client.connect(host, 8080)){
  Serial.println("connected]");

    temperatura = dht.readTemperature();
    humedad = dht.readHumidity();

    Serial.println("**************************************************");
    Serial.print("Temperatura actual: "); Serial.print(temperatura); Serial.println(" °C");
    Serial.print("Humedad actual: "); Serial.print(humedad, 2); Serial.println(" %");
    Serial.println("**************************************************");
 -
    Serial.println("[Sending a request]");
    client.print(String("GET /weather/save?t=") + temperatura + "&h=" + humedad + "&l=" + location + " HTTP/1.1\r\n" +
                 "Host: " + host + "\r\n" +
                 "Connection: close\r\n" +
                 "\r\n"
                );

    Serial.println("[Response:]");
    while (client.connected()) {
      if ( client.available()) {
        String line = client.readStringUntil('\n');
        Serial.println(line);
      }
    }
    client.stop();
    Serial.println("\n[Disconnected]");
  } else {
    Serial.println("connection failed!");
  }
  delay(delayInMinutes*60000);
}