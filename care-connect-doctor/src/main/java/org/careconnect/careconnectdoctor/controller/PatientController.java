package org.careconnect.careconnectdoctor.controller;

import org.careconnect.careconnectdoctor.config.feignproxy.PatientFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    @Autowired
    PatientFeign patientFeign;

    @GetMapping("/illnesses/patients/{patient_Id}")
    public ResponseEntity getIllness(Long patient_Id){
        return patientFeign.illnessHistory(patient_Id);
    }
}
