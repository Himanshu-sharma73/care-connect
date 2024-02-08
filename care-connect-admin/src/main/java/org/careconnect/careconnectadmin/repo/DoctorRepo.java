package org.careconnect.careconnectadmin.repo;

import org.careconnect.careconnectadmin.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepo extends JpaRepository<DoctorEntity,Long> {
    boolean existsByEmail(String email);
    boolean existsByAdharNo(long adharNo);
}
