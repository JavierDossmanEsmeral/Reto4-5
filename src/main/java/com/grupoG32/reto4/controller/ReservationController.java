package com.grupoG32.reto4.controller;

import com.grupoG32.reto4.dbo.MessageDbo;
import com.grupoG32.reto4.dbo.ReportClientsDbo;
import com.grupoG32.reto4.dbo.RepostStatusDbo;
import com.grupoG32.reto4.dbo.ReservationDbo;
import com.grupoG32.reto4.model.ClientModel;
import com.grupoG32.reto4.model.MessageModel;
import com.grupoG32.reto4.model.ReservationModel;
import com.grupoG32.reto4.service.ClientService;
import com.grupoG32.reto4.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(value = "*")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @Autowired
    ClientService clientService;

    @GetMapping("/report-dates/{fechaInicio}/{fechaFin}")
    public List<ReservationModel> reportDate(@PathVariable String fechaInicio, @PathVariable String fechaFin) throws ParseException {
        return reservationService.reportDate(fechaInicio,fechaFin);
    }

    @GetMapping("/report-status")
    public RepostStatusDbo reportStatus(){
        return reservationService.reportStatus();
    }

    @GetMapping("/report-clients")
    public List<ReportClientsDbo> reportClients(){
        return clientService.reportClients();
    }

    @GetMapping("/{id}")
    Optional<ReservationModel> obtenerPorId(@PathVariable int id){
        return reservationService.obtenerPorId(id);
    }

    @GetMapping("/all")
    public List<ReservationModel> obtener(){
        return reservationService.obtener();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void crear(@RequestBody ReservationModel reservation){
        reservationService.crear(reservation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable int id){
        reservationService.eliminar(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void actualizar(@RequestBody ReservationDbo reservationInput){
        reservationService.actualizar(reservationInput);
    }
}

