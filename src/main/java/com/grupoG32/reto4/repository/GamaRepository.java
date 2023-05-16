package com.grupoG32.reto4.repository;

import com.grupoG32.reto4.model.GamaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamaRepository extends JpaRepository<GamaModel,Integer> {

}
