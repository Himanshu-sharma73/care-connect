package org.careconnect.careconnectadmin.controller;

import jakarta.validation.Valid;
import org.careconnect.careconnectadmin.entity.DoctorEntity;
import org.careconnect.careconnectadmin.exception.DoctorExitException;
import org.careconnect.careconnectadmin.repo.DoctorRepo;
import org.careconnect.careconnectadmin.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    DoctorRepo doctorRepo;


    @PostMapping("/doctors")
    public ResponseEntity<ApiResponse> postDoctors(@Valid @RequestBody DoctorEntity doctor){
        if(doctorRepo.existsByEmail(doctor.getEmail())){
            throw new DoctorExitException("Doctor","Email",doctor.getEmail());
        }else if(doctorRepo.existsByAdharNo(doctor.getAdharNo())){
            throw new DoctorExitException("Doctor","Adhar",String.valueOf(doctor.getAdharNo()));
        }
        DoctorEntity savedDoctor = doctorRepo.save(doctor);
        ApiResponse apiResponse=new ApiResponse();
        apiResponse.setData(savedDoctor);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/doctors")
    public ResponseEntity<ApiResponse> getDoctors(){
        List<DoctorEntity> allDoctor = doctorRepo.findAll();
        ApiResponse apiResponse=new ApiResponse();
        apiResponse.setData(allDoctor);
        return ResponseEntity.ok(apiResponse);
    }
}
