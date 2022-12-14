/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.Spring.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upeu.Spring.entity.Sesion;
import pe.edu.upeu.Spring.service.SesionService;

/**
 *
 * @author tpp
 */
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/sesion")
@Api(value = "Microservicio de gestión de sesiones", description = "Microservicio de Sesión")
public class SesionController {

    @Autowired
    SesionService sesionService;

    @ApiOperation(value = "Lista de sesiones")
    @GetMapping
    public ResponseEntity<?> findAll() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Lista de sesiones");
        result.put("data", sesionService.findAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene datos de una sesión")
    @GetMapping("/{id}")
    public ResponseEntity<Sesion> findById(@PathVariable Long id) {
        Sesion sesion = sesionService.findById(id);
        return ResponseEntity.ok(sesion);
    }

    @ApiOperation(value = "Obtiene datos de una sesión")
    @GetMapping("/taller/{id}")
    public ResponseEntity<?> findByTallerId(@PathVariable Long id) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Lista de sesiones por taller id");
        result.put("data", sesionService.findByTallerId(id));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @ApiOperation(value = "Crea una sesión")
    @PostMapping("/save")
    public Sesion save(@RequestBody Sesion sesion) {
        return sesionService.save(sesion);
    }

    @ApiOperation(value = "Crea 4 sesiones por defecto a un taller")
    @GetMapping("/save4Default/taller/{id}")
    public List<Sesion> save4Default(@PathVariable Long id) {
        return sesionService.save4Default(id);
    }

    @ApiOperation(value = "Modifica una sesión")
    @PutMapping("/update")
    public Sesion update(@RequestBody Sesion sesion) {
        return sesionService.save(sesion);
    }

    @ApiOperation(value = "Elimina una sesión")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        sesionService.deleteById(id);
    }
}
