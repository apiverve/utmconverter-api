/**
 * Basic Example - UTM Coordinate Converter API
 *
 * This example demonstrates how to use the UTM Coordinate Converter API.
 * Make sure to set your API key in the .env file or replace '[YOUR_API_KEY]' below.
 */

require('dotenv').config();
const utmconverterAPI = require('../index.js');

// Initialize the API client
const api = new utmconverterAPI({
    api_key: process.env.API_KEY || '[YOUR_API_KEY]'
});

// Example query
var query = {
  direction: "to_utm",
  latitude: 40.7128,
  longitude: -74.0060,
  zone: 18,
  easting: 585628,
  northing: 4511322,
  hemisphere: "N"
};

// Make the API request using callback
console.log('Making request to UTM Coordinate Converter API...\n');

api.execute(query, function (error, data) {
    if (error) {
        console.error('Error occurred:');
        if (error.error) {
            console.error('Message:', error.error);
            console.error('Status:', error.status);
        } else {
            console.error(JSON.stringify(error, null, 2));
        }
        return;
    }

    console.log('Response:');
    console.log(JSON.stringify(data, null, 2));
});
