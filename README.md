# 🌦️ Real-Time Weather Monitoring System using Kafka, Python, Java & JavaFX

This project fetches real-time weather data from the OpenWeatherMap API using Python and streams it using **Apache Kafka**. A **JavaFX GUI** consumes this data and visualizes the live weather conditions. It also stores weather updates in an SQLite database for trend analysis and charting.

---

## 📦 Tech Stack

- **Python**: For collecting weather data and producing to Kafka
- **Apache Kafka**: Message broker for data streaming
- **Java + JavaFX**: GUI for visualizing real-time weather
- **SQLite**: Local database for storing weather history

---

## 📁 Folder Structure
├── python-producer/ │ ├── weather_producer.py │ ├── .env │ ├── requirements.txt │ ├── java-consumer/ │ ├── WeatherMonitoringUI.java │ ├── DatabaseManager.java │ ├── WeatherChartUI.java │ ├── README.md

---

## 🔧 Prerequisites

### ✅ Python
- Python 3.8+
- Pip installed

### ✅ Java
- Java 17 or newer
- JavaFX SDK installed
- SQLite JDBC driver

### ✅ Apache Kafka
- Kafka and Zookeeper installed and configured locally

---

## 🔨 Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/weather-monitoring-kafka.git
cd weather-monitoring-kafka
2. Kafka Setup
Start Zookeeper:

bash
Copy
Edit
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
Start Kafka broker:

bash
Copy
Edit
.\bin\windows\kafka-server-start.bat .\config\server.properties
Create Kafka topic:

bash
Copy
Edit
.\bin\windows\kafka-topics.bat --create --topic weather-data --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1
3. Python Producer Setup
Navigate to the producer folder:

bash
Copy
Edit
cd python-producer
Install dependencies:
bash
Copy
Edit
pip install -r requirements.txt
Add your API key in .env file:
Create a .env file:

env
Copy
Edit
OPENWEATHERMAP_API_KEY=your_api_key_here
Run the producer:
bash
Copy
Edit
python weather_producer.py
4. Java Consumer Setup (JavaFX GUI)
Ensure the following are available in your classpath:

kafka-clients-x.x.x.jar

sqlite-jdbc-x.x.x.jar

JavaFX SDK (lib folder)

Compile and Run:
bash
Copy
Edit
javac -cp ".;path_to/kafka-clients.jar;path_to/sqlite-jdbc.jar;path_to/javafx/lib/*" com/example/weather/ui/*.java

java -cp ".;...libs..." --module-path path_to/javafx/lib --add-modules javafx.controls,javafx.fxml com.example.weather.ui.WeatherMonitoringUI
🖼️ Features
🔁 Live updates every 10 seconds

🌍 Weather info from multiple global cities

📈 Weather trends in charts (JavaFX)

💾 Historical logging to SQLite

🧩 Kafka decouples producer and consumer

🧪 Project Flow
Python producer:

Fetches data from OpenWeatherMap API

Pushes weather JSON to Kafka topic weather-data

Kafka Broker:

Streams weather messages to subscribed consumers

JavaFX GUI:

Consumes Kafka data

Updates weather UI in real time

Saves each record in SQLite

Visualizes trends in a separate chart view

✅ requirements.txt
txt
Copy
Edit
kafka-python
requests
python-dotenv
Install via:

bash
Copy
Edit
pip install -r requirements.txt
🛠 Troubleshooting
Kafka not working? Check if Zookeeper and Kafka are running.

No UI updates? Ensure the topic exists and messages are being sent.

Database not updating? Check if the insertWeatherData() function is called and your DB path is correct.

🧩 Kafka Config Summary
Broker: localhost:9092

Topic: weather-data

Producer: Python script

Consumer: Java application

📄 License
This project is for educational/demo purposes only.

🙌 Author
Developed by: Your Name
For: Your Institution

yaml
Copy
Edit

---

Let me know if you'd like this bundled into a `.zip`, or need a shell/batch script for automated setup!





You said:
PROVIDE IN ONE SINGLE README FILE SO I CAN PASTE IN GITHUB


ChatGPT said:
Absolutely! Here's the complete README.md file content that you can directly copy-paste into your GitHub repo:

markdown
Copy
Edit
# 🌦️ Real-Time Weather Monitoring System using Kafka, Python, Java & JavaFX

This project fetches real-time weather data from the OpenWeatherMap API using **Python** and streams it using **Apache Kafka**. A **JavaFX-based GUI** then consumes this data and visualizes live weather conditions. All weather data is stored in an **SQLite database** for trend analysis and charting.

---

## 📦 Tech Stack

- **Python** – Fetch and produce real-time weather data
- **Apache Kafka** – Streaming platform for real-time communication
- **Java + JavaFX** – Interactive UI for displaying weather info
- **SQLite** – Lightweight database to store and visualize trends

---

## 📁 Folder Structure

weather-monitoring-kafka/ ├── python-producer/ │ ├── weather_producer.py │ ├── .env │ ├── requirements.txt │ ├── java-consumer/ │ ├── WeatherMonitoringUI.java │ ├── DatabaseManager.java │ ├── WeatherChartUI.java │ ├── README.md

yaml
Copy
Edit

---

## 🔧 Prerequisites

### ✅ Python
- Python 3.8 or higher
- `pip` for dependency management

### ✅ Java
- Java 17 or higher
- JavaFX SDK installed
- SQLite JDBC driver

### ✅ Apache Kafka
- Kafka and Zookeeper installed and configured locally

---

## 🛠 Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/weather-monitoring-kafka.git
cd weather-monitoring-kafka
2. Kafka Setup
Start Zookeeper:
bash
Copy
Edit
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
Start Kafka Broker:
bash
Copy
Edit
.\bin\windows\kafka-server-start.bat .\config\server.properties
Create Kafka Topic:
bash
Copy
Edit
.\bin\windows\kafka-topics.bat --create --topic weather-data --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1
3. Python Weather Producer Setup
Navigate to the Python folder:

bash
Copy
Edit
cd python-producer
Create .env file:
ini
Copy
Edit
OPENWEATHERMAP_API_KEY=your_openweathermap_api_key_here
Install dependencies:
bash
Copy
Edit
pip install -r requirements.txt
Run the producer:
bash
Copy
Edit
python weather_producer.py
4. Java Kafka Consumer with JavaFX UI
Ensure the following are available in your classpath:

kafka-clients-x.x.x.jar

sqlite-jdbc-x.x.x.jar

JavaFX SDK (lib folder)

Compile Java Files:
bash
Copy
Edit
javac -cp ".;path_to/kafka-clients.jar;path_to/sqlite-jdbc.jar;path_to/javafx/lib/*" com/example/weather/ui/*.java
Run the JavaFX Application:
bash
Copy
Edit
java -cp ".;...libs..." --module-path path_to/javafx/lib --add-modules javafx.controls,javafx.fxml com.example.weather.ui.WeatherMonitoringUI
✅ This GUI will:

Display live updates of temperature, humidity, wind speed, etc.

Log every update to a local SQLite database

Provide a button to visualize weather trends using a chart

✅ requirements.txt (Python)
Copy
Edit
kafka-python
requests
python-dotenv
Install using:

bash
Copy
Edit
pip install -r requirements.txt
💡 Project Workflow
Python Producer

Fetches live weather data for cities like London, Tokyo, etc.

Sends data to the Kafka topic weather-data every 10 seconds

Kafka Broker

Acts as a streaming pipeline

Java Consumer

Reads weather messages in real-time

Updates UI labels and stores data in SQLite

Allows users to view historical charts using JavaFX

📊 Features
🔁 Real-time weather updates for multiple cities

📦 Kafka used for decoupled communication

💾 SQLite storage of historical weather

📈 Chart-based trend analysis with JavaFX

🧠 Extendable for alerts, notifications, analytics

🧩 Kafka Config Summary
Config Option	Value
Kafka Topic	weather-data
Broker Address	localhost:9092
Producer (Python)	weather_producer.py
Consumer (Java)	WeatherMonitoringUI
🐞 Troubleshooting
Kafka not connecting? Make sure Zookeeper and Kafka are running.

No GUI updates? Ensure producer is sending data and topic exists.

Database not updating? Check SQLite path and ensure insertion is called.

API not working? Ensure your OpenWeatherMap API key is valid and added to .env.

🧠 Future Enhancements
Add weather alerts

Enable city selection in GUI

Display graphs for each metric (humidity, pressure, etc.)

Containerize with Docker

👨‍💻 Author
Developed by Shreeyash Jagtap
Sarthak Mudholkar
Harshwardhan Paygude
Harshvardhan Misal
Ayush Salunke
For academic/demo purposes at MIT WPI



