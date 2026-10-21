# UTM Coordinate Converter API - Ruby Gem

UTM Coordinate Converter provides bidirectional conversion between UTM (Universal Transverse Mercator) coordinates and latitude/longitude using WGS84 datum.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_utmconverter'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_utmconverter
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_utmconverter'

# Initialize the client
client = APIVerve::Utmconverter::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({
  direction: "to_utm",
  latitude: 40.7128,
  longitude: -74.006
})

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ direction: "to_utm", latitude: 40.7128, longitude: -74.006 })
  puts response["data"]
rescue APIVerve::Utmconverter::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Utmconverter::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Utmconverter::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
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

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/utmconverter?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/utmconverter?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/utmconverter?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
