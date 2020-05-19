package com.pec.connect.repo;

import com.pec.connect.entity.RolePermissionMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolePermissionMappingRepository extends JpaRepository<RolePermissionMapping, Long> {

    List<RolePermissionMapping> findAllByRoleId(Long roleId);
}
