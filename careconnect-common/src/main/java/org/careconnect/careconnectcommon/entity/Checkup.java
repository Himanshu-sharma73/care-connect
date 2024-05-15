package org.careconnect.careconnectcommon.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "checkup")
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Checkup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long checkupId;

    private long appointmentId;


    @JsonIgnoreProperties
    private String checkupStatus;

    private String prescription;

    private String extraComment;

}
