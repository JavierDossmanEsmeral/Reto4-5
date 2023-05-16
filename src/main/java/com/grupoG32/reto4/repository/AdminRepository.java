package com.grupoG32.reto4.repository;

import com.grupoG32.reto4.model.AdminModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminModel,Integer> {

}
