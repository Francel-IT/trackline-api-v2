package com.trackline.tracking.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@ToString
public class ResponseModel {
    @JsonProperty("StatusCode")
    private  Integer StatusCode;
    @JsonProperty("Message")
    private  String Message;
    @JsonProperty("TimeStamp")
    private OffsetDateTime TimeStamp;
}
