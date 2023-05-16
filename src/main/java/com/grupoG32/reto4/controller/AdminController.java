package com.grupoG32.reto4.controller;

import com.grupoG32.reto4.dbo.AdminDbo;
import com.grupoG32.reto4.model.AdminModel;
import com.grupoG32.reto4.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(value = "*")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping("/all")
    public List<AdminModel> obtenerAdministradores(){
        return adminService.obtenerAdministradores();
    }

    //Todo: Solucionar error
    @PostMapping("/save")
    public String crearAdministradores(@RequestBody AdminDbo admin){
        //return adminService.crearAdministradores(admin);
        return null;
    }
}
