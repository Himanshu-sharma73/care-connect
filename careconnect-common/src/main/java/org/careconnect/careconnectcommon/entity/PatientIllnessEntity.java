package org.careconnect.careconnectcommon.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "patient_illness")
@Data
@ToString
public class PatientIllnessEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long illnessId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_Id")
    @JsonIgnore
    private  PatientEntity patient;

    @NotNull(message = "Illness list must not be null")
    @NotEmpty(message = "Illness list must not be empty")
    private List<String> illness;

    @NotBlank(message = "Description must not be blank")
    @Column(columnDefinition = "TEXT")
    private String description;

    @NotNull(message = "Date must not be null")
    private LocalDate illnessDate;
}
