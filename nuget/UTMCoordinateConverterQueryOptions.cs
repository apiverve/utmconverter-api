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
        /// Conversion direction
        /// </summary>
        [JsonProperty("direction")]
        public string Direction { get; set; }

        /// <summary>
        /// Latitude (-90 to 90)
        /// </summary>
        [JsonProperty("latitude")]
        public string Latitude { get; set; }

        /// <summary>
        /// Longitude (-180 to 180)
        /// </summary>
        [JsonProperty("longitude")]
        public string Longitude { get; set; }
    }
}
