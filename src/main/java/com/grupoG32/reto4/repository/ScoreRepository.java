package com.grupoG32.reto4.repository;

import com.grupoG32.reto4.model.ScoreModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<ScoreModel,Integer> {

}
