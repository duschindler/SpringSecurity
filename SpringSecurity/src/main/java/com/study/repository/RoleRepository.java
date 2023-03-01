package com.study.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID>{

}
