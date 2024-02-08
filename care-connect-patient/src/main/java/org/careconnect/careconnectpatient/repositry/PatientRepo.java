package org.careconnect.careconnectpatient.repositry;

import org.careconnect.careconnectpatient.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<PatientEntity,Long> {

    boolean existsByEmail(String email);
    boolean existsByAdharNo(long adharNo);
}
