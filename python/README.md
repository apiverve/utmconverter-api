UTM Coordinate Converter API
============

UTM Coordinate Converter provides bidirectional conversion between UTM (Universal Transverse Mercator) coordinates and latitude/longitude using WGS84 datum.

![Build Status](https://img.shields.io/badge/build-passing-green)
![Code Climate](https://img.shields.io/badge/maintainability-B-purple)
![Prod Ready](https://img.shields.io/badge/production-ready-blue)

This is a Python API Wrapper for the [UTM Coordinate Converter API](https://apiverve.com/marketplace/api/utmconverter)

---

## Installation
	pip install apiverve-utmcoordinateconverter

---

## Configuration

Before using the utmconverter API client, you have to setup your account and obtain your API Key.  
You can get it by signing up at [https://apiverve.com](https://apiverve.com)

---

## Usage

The UTM Coordinate Converter API documentation is found here: [https://docs.apiverve.com/api/utmconverter](https://docs.apiverve.com/api/utmconverter).  
You can find parameters, example responses, and status codes documented here.

### Setup

```
# Import the client module
from apiverve_utmcoordinateconverter.apiClient import UtmconverterAPIClient

# Initialize the client with your APIVerve API key
api = UtmconverterAPIClient("[YOUR_API_KEY]")
```

---


### Perform Request
Using the API client, you can perform requests to the API.

###### Define Query

```
query = { "direction": "to_utm", "latitude": 40.7128, "longitude": -74.0060, "zone": 18, "easting": 585628, "northing": 4511322, "hemisphere": "N" }
```

###### Simple Request

```
# Make a request to the API
result = api.execute(query)

# Print the result
print(result)
```

###### Example Response

```
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

---

## Customer Support

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact).

---

## Updates
Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the APIVerve website, API, and services is subject to the [APIVerve Terms of Service](https://apiverve.com/terms) and all legal documents and agreements.

---

## License
Licensed under the The MIT License (MIT)

Copyright (&copy;) 2025 APIVerve, and EvlarSoft LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.