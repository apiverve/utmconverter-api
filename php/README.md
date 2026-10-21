# UTM Coordinate Converter API - PHP Package

UTM Coordinate Converter provides bidirectional conversion between UTM (Universal Transverse Mercator) coordinates and latitude/longitude using WGS84 datum.

## Installation

Install via Composer:

```bash
composer require apiverve/utmconverter
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Utmconverter\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute([
    'direction' => 'to_utm',
    'latitude' => 40.7128,
    'longitude' => -74.006
]);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Utmconverter\Client;
use APIVerve\Utmconverter\Exceptions\APIException;
use APIVerve\Utmconverter\Exceptions\ValidationException;

try {
    $response = $client->execute(['direction' => 'to_utm', 'latitude' => 40.7128, 'longitude' => -74.006]);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
```

## Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "conversion": "lat/lon to UTM",
    "input": {
      "latitude": 40.7128,
      "longitude": -74.006
    },
    "output": {
      "zone": 18,
      "hemisphere": "N",
      "easting": 583959.37,
      "northing": 4507351
    },
    "formatted": "18N 583959E 4507351N",
    "datum": "WGS84"
  }
}
```

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/utmconverter?utm_source=packagist&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/utmconverter?utm_source=php&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/utmconverter?utm_source=php&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
