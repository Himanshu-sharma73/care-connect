package org.careconnect.careconnectadmin.controller;

import jakarta.validation.Valid;
import org.careconnect.careconnectadmin.entity.DoctorEntity;
import org.careconnect.careconnectadmin.entity.Specialization;
import org.careconnect.careconnectadmin.exception.DoctorExitException;
import org.careconnect.careconnectadmin.exception.ResourceNotFoundException;
import org.careconnect.careconnectadmin.repo.DoctorRepo;
import org.careconnect.careconnectadmin.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/doctors/{doctorId}")
    ResponseEntity<ApiResponse> getDoctorById(@PathVariable long doctorId){
        Optional<DoctorEntity> optionalDoctor = doctorRepo.findById(doctorId);
        if(optionalDoctor.isPresent()) {
            DoctorEntity doctor=optionalDoctor.get();
            ApiResponse apiResponse = new ApiResponse();
            apiResponse.setData(doctor);
            return ResponseEntity.ok(apiResponse);
        }
        else {
            throw new ResourceNotFoundException("Doctor","Id",String.valueOf(doctorId));
        }
    }

    @GetMapping("/doctor/specialization/{specialization}")
    public ResponseEntity<ApiResponse> findBySpecialization(@PathVariable String specialization) {
        try {
            Specialization enumSpecialization = Specialization.valueOf(specialization.toUpperCase());
            Optional<DoctorEntity> optionalDoctor = doctorRepo.findBySpecialization(enumSpecialization);
            if (optionalDoctor.isPresent()) {
                DoctorEntity doctor = optionalDoctor.get();
                ApiResponse apiResponse=new ApiResponse();
                apiResponse.setData(doctor);
                return ResponseEntity.ok(apiResponse);
            }

            throw new ResourceNotFoundException("Doctor", "Specialization", specialization);
        } catch (IllegalArgumentException e) {
            throw new ResourceNotFoundException(
                    "Entered Specialization",
                    "Specialization",
                    specialization +'\n'+
                            "Available Specializations: " + Arrays.toString(Specialization.values())
            );
        }
    }

}
