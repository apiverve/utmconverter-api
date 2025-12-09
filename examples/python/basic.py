"""
UTM Coordinate Converter API - Basic Usage Example

This example demonstrates the basic usage of the UTM Coordinate Converter API.
API Documentation: https://docs.apiverve.com/ref/utmconverter
"""

import os
import requests
import json

API_KEY = os.getenv('APIVERVE_API_KEY', 'YOUR_API_KEY_HERE')
API_URL = 'https://api.apiverve.com/v1/utmconverter'

def call_utmconverter_api():
    """
    Make a GET request to the UTM Coordinate Converter API
    """
    try:
        # Query parameters
        params &#x3D; {&#x27;direction&#x27;: &#x27;to_utm&#x27;, &#x27;latitude&#x27;: 40.7128, &#x27;longitude&#x27;: -74.0060, &#x27;zone&#x27;: 18, &#x27;easting&#x27;: 585628, &#x27;northing&#x27;: 4511322, &#x27;hemisphere&#x27;: &#x27;N&#x27;}

        headers = {
            'x-api-key': API_KEY
        }

        response = requests.get(API_URL, headers=headers, params=params)

        # Raise exception for HTTP errors
        response.raise_for_status()

        data = response.json()

        # Check API response status
        if data.get('status') == 'ok':
            print('✓ Success!')
            print('Response data:', json.dumps(data['data'], indent=2))
            return data['data']
        else:
            print('✗ API Error:', data.get('error', 'Unknown error'))
            return None

    except requests.exceptions.RequestException as e:
        print(f'✗ Request failed: {e}')
        return None

if __name__ == '__main__':
    print('📤 Calling UTM Coordinate Converter API...\n')

    result = call_utmconverter_api()

    if result:
        print('\n📊 Final Result:')
        print(json.dumps(result, indent=2))
    else:
        print('\n✗ API call failed')
