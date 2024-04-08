package org.careconnect.careconnectdoctor.controller;

import org.careconnect.careconnectdoctor.config.feignproxy.PatientFeign;
import org.careconnect.careconnectdoctor.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {

    @Autowired
    PatientFeign patientFeign;

    @GetMapping("/patient/illness/patients/{patient_Id}")
    public ResponseEntity<ApiResponse> getIllness(@PathVariable long patient_Id){
        return patientFeign.illnessHistory(patient_Id);
    }
}
