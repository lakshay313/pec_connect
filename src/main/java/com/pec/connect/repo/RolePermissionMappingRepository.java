package com.pec.connect.repo;

import com.pec.connect.entity.RolePermissionMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePermissionMappingRepository extends JpaRepository<RolePermissionMapping, Long> {

}
