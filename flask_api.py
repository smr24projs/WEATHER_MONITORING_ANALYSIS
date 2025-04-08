from flask import Flask, jsonify, request
import sqlite3

app = Flask(__name__)
DB_PATH = 'weather_history.db'

# Function to fetch current weather data
def get_current_weather():
    with sqlite3.connect(DB_PATH) as conn:
        cursor = conn.cursor()
        cursor.execute('''SELECT city, temperature, humidity, wind_speed, pressure, feels_like, clouds, description, timestamp 
                          FROM weather_data 
                          WHERE timestamp = (SELECT MAX(timestamp) FROM weather_data WHERE city = weather_data.city)''')
        data = cursor.fetchall()
    
    weather_info = [{
        'city': row[0],
        'temperature': row[1],
        'humidity': row[2],
        'wind_speed': row[3],
        'pressure': row[4],
        'feels_like': row[5],
        'clouds': row[6],
        'description': row[7],
        'timestamp': row[8]
    } for row in data]
    
    return weather_info

# Function to fetch historical weather data for a city
def get_city_weather(city, hours):
    with sqlite3.connect(DB_PATH) as conn:
        cursor = conn.cursor()
        cursor.execute('''SELECT city, temperature, humidity, wind_speed, pressure, feels_like, clouds, description, timestamp 
                          FROM weather_data 
                          WHERE city = ? AND timestamp > datetime('now', ?)''', (city, f'-{hours} hours'))
        data = cursor.fetchall()
    
    history = [{
        'city': row[0],
        'temperature': row[1],
        'humidity': row[2],
        'wind_speed': row[3],
        'pressure': row[4],
        'feels_like': row[5],
        'clouds': row[6],
        'description': row[7],
        'timestamp': row[8]
    } for row in data]
    
    return history

@app.route('/current_weather', methods=['GET'])
def current_weather():
    return jsonify(get_current_weather())

@app.route('/city_weather', methods=['GET'])
def city_weather():
    city = request.args.get('city')
    hours = request.args.get('hours', default=24, type=int)
    return jsonify(get_city_weather(city, hours))

if __name__ == '__main__':
    app.run(debug=True, port=5000)
