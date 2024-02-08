package org.careconnect.careconnectpatient.controller;

import jakarta.validation.Valid;
import org.careconnect.careconnectpatient.entity.PatientEntity;
import org.careconnect.careconnectpatient.exception.PatientExitException;
import org.careconnect.careconnectpatient.repositry.PatientRepo;
import org.careconnect.careconnectpatient.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    PatientRepo patientRepo;

    @PostMapping("/patients")
    public ResponseEntity<ApiResponse> registerPatient(@Valid @RequestBody PatientEntity patientEntity){
            if(patientRepo.existsByEmail(patientEntity.getEmail())){
                throw new PatientExitException("Patient","EmailId",patientEntity.getEmail());
            }else if(patientRepo.existsByAdharNo(patientEntity.getAdharNo())) {
                throw new PatientExitException("Patient","AdharNo",String.valueOf(patientEntity.getAdharNo()));
            }else {
                PatientEntity savedPatient=patientRepo.save(patientEntity);
                ApiResponse apiResponse=new ApiResponse();
                apiResponse.setData(savedPatient);
                return ResponseEntity.ok(apiResponse);
            }
    }

    @GetMapping("/patients")
    public List retrievePatients(){
        return patientRepo.findAll();
    }
}
