using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.UTMCoordinateConverter
{
    /// <summary>
    /// Query options for the UTM Coordinate Converter API
    /// </summary>
    public class UTMCoordinateConverterQueryOptions
    {
        /// <summary>
        /// Conversion direction (to_utm or from_utm)
        /// Example: to_utm
        /// </summary>
        [JsonProperty("direction")]
        public string Direction { get; set; }

        /// <summary>
        /// Latitude (-90 to 90) - required for to_utm
        /// Example: 40.7128
        /// </summary>
        [JsonProperty("latitude")]
        public string Latitude { get; set; }

        /// <summary>
        /// Longitude (-180 to 180) - required for to_utm
        /// Example: -74.0060
        /// </summary>
        [JsonProperty("longitude")]
        public string Longitude { get; set; }

        /// <summary>
        /// UTM zone (1-60) - required for from_utm
        /// Example: 18
        /// </summary>
        [JsonProperty("zone")]
        public string Zone { get; set; }

        /// <summary>
        /// UTM easting - required for from_utm
        /// Example: 585628
        /// </summary>
        [JsonProperty("easting")]
        public string Easting { get; set; }

        /// <summary>
        /// UTM northing - required from_utm
        /// Example: 4511322
        /// </summary>
        [JsonProperty("northing")]
        public string Northing { get; set; }

        /// <summary>
        /// Hemisphere (N or S) - required for from_utm
        /// Example: N
        /// </summary>
        [JsonProperty("hemisphere")]
        public string Hemisphere { get; set; }
    }
}
