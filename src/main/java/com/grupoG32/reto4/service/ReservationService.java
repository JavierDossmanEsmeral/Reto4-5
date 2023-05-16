package com.grupoG32.reto4.service;

import com.grupoG32.reto4.dbo.RepostStatusDbo;
import com.grupoG32.reto4.dbo.ReservationDbo;
import com.grupoG32.reto4.model.ClientModel;
import com.grupoG32.reto4.model.MessageModel;
import com.grupoG32.reto4.model.ReservationModel;
import com.grupoG32.reto4.repository.ClientRepository;
import com.grupoG32.reto4.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    public List<ReservationModel> obtener(){
        return reservationRepository.findAll();
    }

    public void crear(ReservationModel reservation){
        reservationRepository.save(reservation);
    }

    public void eliminar(int id){
        reservationRepository.deleteById(id);
    }

    public void actualizar(ReservationDbo reservationInput) {
        Optional<ReservationModel> reservationDb = reservationRepository.findById(reservationInput.getIdReservation());
        if(reservationDb.isPresent()){
            ReservationModel reservation = reservationDb.get();
            if (reservationInput.getStartDate() != null){
                reservation.setStartDate(reservationInput.getStartDate());
            }
            if (reservationInput.getDevolutionDate() != null){
                reservation.setDevolutionDate(reservationInput.getDevolutionDate());
            }
            if (reservationInput.getScore() != null){
                reservation.setScore(reservationInput.getScore());
            }
            if (reservationInput.getStatus() != null){
                reservation.setStatus(reservationInput.getStatus());
            }
            if (reservationInput.getCar() != null){
                reservation.setCar(reservationInput.getCar());
            }
            if (reservationInput.getClient() != null){
                reservation.setClient(reservationInput.getClient());
            }
            reservationRepository.save(reservation);
        }
    }

    public Optional<ReservationModel> obtenerPorId(int id) {
        return reservationRepository.findById(id);
    }

    public List<ReservationModel> reportDate(String fechaInicio, String fechaFin) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
        Date fechaInicioDate = format.parse(fechaInicio);
        Date fechaFinDate = format.parse(fechaFin);
        if(fechaInicioDate.before(fechaFinDate)){
            return reservationRepository.findByStartDateBetween(fechaInicioDate,fechaFinDate);
        }
        return null;
    }

    public RepostStatusDbo reportStatus() {
        Integer coutCompleted = reservationRepository.countByStatus("completed");
        Integer coutCancelled = reservationRepository.countByStatus("cancelled");
        return new RepostStatusDbo(coutCompleted,coutCancelled);
    }


}
