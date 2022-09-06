package com.trackline.tracking.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import java.time.OffsetDateTime;


@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
 public class CreationModel {
    @JsonProperty("Datecreated")
    private OffsetDateTime datecreated;
    @JsonProperty("Createdby")
    private String createdby;
    @JsonProperty("Dateupdated")
    private OffsetDateTime dateupdated;
    @JsonProperty("Updatedby")
    private String updatedby;

}
