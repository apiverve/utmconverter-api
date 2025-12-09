// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     UTMCoordinateConverterData data = Converter.fromJsonString(jsonString);

package com.apiverve.utmconverter.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static UTMCoordinateConverterData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(UTMCoordinateConverterData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(UTMCoordinateConverterData.class);
        writer = mapper.writerFor(UTMCoordinateConverterData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// UTMCoordinateConverterData.java

package com.apiverve.utmconverter.data;

import com.fasterxml.jackson.annotation.*;

public class UTMCoordinateConverterData {
    private String conversion;
    private Input input;
    private Output output;
    private String formatted;
    private String datum;

    @JsonProperty("conversion")
    public String getConversion() { return conversion; }
    @JsonProperty("conversion")
    public void setConversion(String value) { this.conversion = value; }

    @JsonProperty("input")
    public Input getInput() { return input; }
    @JsonProperty("input")
    public void setInput(Input value) { this.input = value; }

    @JsonProperty("output")
    public Output getOutput() { return output; }
    @JsonProperty("output")
    public void setOutput(Output value) { this.output = value; }

    @JsonProperty("formatted")
    public String getFormatted() { return formatted; }
    @JsonProperty("formatted")
    public void setFormatted(String value) { this.formatted = value; }

    @JsonProperty("datum")
    public String getDatum() { return datum; }
    @JsonProperty("datum")
    public void setDatum(String value) { this.datum = value; }
}

// Input.java

package com.apiverve.utmconverter.data;

import com.fasterxml.jackson.annotation.*;

public class Input {
    private double latitude;
    private double longitude;

    @JsonProperty("latitude")
    public double getLatitude() { return latitude; }
    @JsonProperty("latitude")
    public void setLatitude(double value) { this.latitude = value; }

    @JsonProperty("longitude")
    public double getLongitude() { return longitude; }
    @JsonProperty("longitude")
    public void setLongitude(double value) { this.longitude = value; }
}

// Output.java

package com.apiverve.utmconverter.data;

import com.fasterxml.jackson.annotation.*;

public class Output {
    private long zone;
    private String hemisphere;
    private double easting;
    private long northing;

    @JsonProperty("zone")
    public long getZone() { return zone; }
    @JsonProperty("zone")
    public void setZone(long value) { this.zone = value; }

    @JsonProperty("hemisphere")
    public String getHemisphere() { return hemisphere; }
    @JsonProperty("hemisphere")
    public void setHemisphere(String value) { this.hemisphere = value; }

    @JsonProperty("easting")
    public double getEasting() { return easting; }
    @JsonProperty("easting")
    public void setEasting(double value) { this.easting = value; }

    @JsonProperty("northing")
    public long getNorthing() { return northing; }
    @JsonProperty("northing")
    public void setNorthing(long value) { this.northing = value; }
}