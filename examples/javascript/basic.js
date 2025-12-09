/**
 * UTM Coordinate Converter API - Basic Usage Example
 *
 * This example demonstrates the basic usage of the UTM Coordinate Converter API.
 * API Documentation: https://docs.apiverve.com/ref/utmconverter
 */

const API_KEY = process.env.APIVERVE_API_KEY || 'YOUR_API_KEY_HERE';
const API_URL = 'https://api.apiverve.com/v1/utmconverter';

/**
 * Make a GET request to the UTM Coordinate Converter API
 */
async function callUTMCoordinateConverterAPI() {
  try {
    // Query parameters
    const params &#x3D; new URLSearchParams({
            direction: &#x27;to_utm&#x27;,
            latitude: 40.7128,
            longitude: -74.0060,
            zone: 18,
            easting: 585628,
            northing: 4511322,
            hemisphere: &#x27;N&#x27;
        });

    const response = await fetch(`${API_URL}?${params}`, {
      method: 'GET',
      headers: {
        'x-api-key': API_KEY
      }
    });

    // Check if response is successful
    if (!response.ok) {
      throw new Error(`HTTP error! status: ${response.status}`);
    }

    const data = await response.json();

    // Check API response status
    if (data.status === 'ok') {
      console.log('✓ Success!');
      console.log('Response data:', data.data);
      return data.data;
    } else {
      console.error('✗ API Error:', data.error || 'Unknown error');
      return null;
    }

  } catch (error) {
    console.error('✗ Request failed:', error.message);
    return null;
  }
}

// Run the example
callUTMCoordinateConverterAPI()
  .then(result => {
    if (result) {
      console.log('\n📊 Final Result:');
      console.log(JSON.stringify(result, null, 2));
    }
  });
