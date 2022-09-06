package com.trackline.tracking.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "location")

public class LocationModel extends  CreationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("Id")
    private Long id;
    @GeneratedValue(strategy =GenerationType.AUTO)
    @JsonProperty("Guid")
    private UUID guid;
    @JsonProperty("Location")
    private  String location;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("Active")
    private String active;



}
