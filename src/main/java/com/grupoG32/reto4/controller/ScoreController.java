package com.grupoG32.reto4.controller;

import com.grupoG32.reto4.dbo.ReservationDbo;
import com.grupoG32.reto4.dbo.ScoreDbo;
import com.grupoG32.reto4.model.ClientModel;
import com.grupoG32.reto4.model.ReservationModel;
import com.grupoG32.reto4.model.ScoreModel;
import com.grupoG32.reto4.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Score")
@CrossOrigin(value = "*")
public class ScoreController {

    @Autowired
    ScoreService scoreService;

    @GetMapping("/all")
    public List<ScoreModel> obtener(){
        return scoreService.obtener();
    }
    @GetMapping("/{id}")
    Optional<ScoreModel> obtenerPorId(@PathVariable int id){
        return scoreService.obtenerPorId(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void crear(@RequestBody ScoreModel score){
        scoreService.crear(score);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable int id){
        scoreService.eliminar(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void actualizar(@RequestBody ScoreDbo scoreInput){
        scoreService.actualizar(scoreInput);
    }
}
