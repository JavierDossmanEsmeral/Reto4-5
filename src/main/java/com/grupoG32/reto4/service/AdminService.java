package com.grupoG32.reto4.service;

import com.grupoG32.reto4.model.AdminModel;
import com.grupoG32.reto4.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public List<AdminModel> obtenerAdministradores(){
        return adminRepository.findAll();
    }

    public String crearAdministradores(AdminModel adminModel){
        adminRepository.save(adminModel);
        return "Se creo el usuario";
    }

}
