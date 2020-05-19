package com.pec.connect.repo;

import com.pec.connect.entity.Identity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IdentityRepository extends JpaRepository<Identity, Long> {

    Optional<Identity> findByEmailAndPassword(String email, String password);

    Optional<Identity> findByIdAndEmail(Long id, String email);

}
