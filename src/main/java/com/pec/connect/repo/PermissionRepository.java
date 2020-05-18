package com.pec.connect.repo;

import com.pec.connect.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepository extends JpaRepository<Permission,Long> {

    List<Permission> findAllByName(String name);

}
