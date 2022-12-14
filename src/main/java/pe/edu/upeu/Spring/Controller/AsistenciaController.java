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

import pe.edu.upeu.Spring.entity.Asistencia;
import pe.edu.upeu.Spring.entity.Sesion;
import pe.edu.upeu.Spring.service.AsistenciaService;

/**
 *
 * @author tpp
 */
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/asistencia")
@Api(value = "Microservicio de gestión de asistencia", description = "Microservicio de asistencia")
public class AsistenciaController {

    @Autowired
    AsistenciaService asistenciaService;

    @ApiOperation(value = "Lista de asistencias")
    @GetMapping
    public ResponseEntity<?> findAll() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Lista de asistencias");
        result.put("data", asistenciaService.findAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene datos de una asistencia")
    @GetMapping("/{id}")
    public ResponseEntity<Asistencia> findById(@PathVariable Long id) {
        Asistencia asistencia = asistenciaService.findById(id);
        return ResponseEntity.ok(asistencia);
    }

    @ApiOperation(value = "Obtiene datos de una asistencia por sesion")
    @GetMapping("/sesion/{id}")
    public ResponseEntity<?> findBySesionId(@PathVariable Long id) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Lista de asistencias");
        result.put("data", asistenciaService.findBySesionId(id));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene estados de asistencias por talleres")
    @GetMapping("/taller/estado")
    public ResponseEntity<?> getEstadosByTaller() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Lista de asistencias");
        result.put("data", asistenciaService.getEstadosByTaller());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Crea una asistencia")
    @PostMapping("/save")
    public Asistencia save(@RequestBody Asistencia asistencia) {
        return asistenciaService.save(asistencia);
    }

    @ApiOperation(value = "Guarda una lista de asistencias")
    @PostMapping("/saveMany")
    public List<Asistencia> saveMany(@RequestBody List<Asistencia> list) {
        return asistenciaService.saveMany(list);
    }

    @ApiOperation(value = "Guarda asistencias por sesiones y persona")
    @PostMapping("/save/persona/{idp}")
    public List<Asistencia> saveSesionPersona(@RequestBody List<Sesion> list, @PathVariable Long idp) {
        return asistenciaService.saveSesionPersona(list, idp);
    }

    @ApiOperation(value = "Modifica una asistencia")
    @PutMapping("/update")
    public Asistencia update(@RequestBody Asistencia asistencia) {
        return asistenciaService.save(asistencia);
    }

    @ApiOperation(value = "Elimina una asistencia")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        asistenciaService.deleteById(id);
    }

    @ApiOperation(value = "Elimina asistencias por Persona y Taller")
    @GetMapping("/delete/persona/{idP}/taller/{idT}")
    public void deleteByPersonaTaller(@PathVariable Long idP, @PathVariable Long idT) {
        asistenciaService.deleteByPersonaTaller(idP, idT);
    }
}
