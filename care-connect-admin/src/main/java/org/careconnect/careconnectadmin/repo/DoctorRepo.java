package org.careconnect.careconnectadmin.repo;

import org.careconnect.careconnectadmin.entity.DoctorEntity;
import org.careconnect.careconnectadmin.entity.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepo extends JpaRepository<DoctorEntity,Long> {
    boolean existsByEmail(String email);
    boolean existsByAdharNo(long adharNo);

    Optional<DoctorEntity> findBySpecialization(Specialization specialization);
}
