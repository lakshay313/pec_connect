package com.pec.connect.repo;

import com.pec.connect.entity.UserRoleMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleMappingRepository extends JpaRepository<UserRoleMapping, Long> {

    Optional<UserRoleMapping> findByUid(Long uid);
}
