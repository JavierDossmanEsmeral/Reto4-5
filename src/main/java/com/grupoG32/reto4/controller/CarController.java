package com.grupoG32.reto4.controller;

import com.grupoG32.reto4.dbo.CarDbo;
import com.grupoG32.reto4.model.CarModel;
import com.grupoG32.reto4.model.ClientModel;
import com.grupoG32.reto4.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Car")
@CrossOrigin(value = "*")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/all")
    public List<CarModel> obtener(){
        return carService.obtener();
    }

    @GetMapping("/{id}")
    Optional<CarModel> obtenerPorId(@PathVariable int id){
        return carService.obtenerPorId(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void crear(@RequestBody CarModel car){
        carService.crear(car);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable int id){
        carService.eliminar(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void actualizar(@RequestBody CarDbo carInput){
        carService.actualizar(carInput);
    }
}
