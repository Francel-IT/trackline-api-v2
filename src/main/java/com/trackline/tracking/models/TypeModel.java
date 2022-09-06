package com.trackline.tracking.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "type")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})

public class TypeModel extends CreationModel  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("Id")
    private Long id;
    @GeneratedValue(strategy =GenerationType.AUTO)
    @JsonProperty("Guid")
    private UUID guid;
    @JsonProperty("Type")
    private  String type;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("Active")
    private String active;
    @JsonIgnore
    private Boolean deleted = false;





}
