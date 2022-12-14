/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.Spring.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
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

import pe.edu.upeu.Spring.entity.Inscripcion;
import pe.edu.upeu.Spring.service.InscripcionService;

/**
 *
 * @author tpp
 */
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/inscripcion")
@Api(value = "Microservicio de gestión de inscripciones", description = "Microservicio de inscripción")
public class InscripcionController {

    @Autowired
    InscripcionService inscripcionService;

    @ApiOperation(value = "Lista de inscripciones")
    @GetMapping
    public ResponseEntity<?> findAll() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Lista de inscripciones");
        result.put("data", inscripcionService.findAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Cantidad de inscritos por taller")
    @GetMapping("/cantidad")
    public ResponseEntity<?> getCantidad() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Lista de inscripciones");
        result.put("data", inscripcionService.getCantidad());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene datos de una inscripcion")
    @GetMapping("/{id}")
    public ResponseEntity<Inscripcion> findById(@PathVariable Long id) {
        Inscripcion inscripcion = inscripcionService.findById(id);
        return ResponseEntity.ok(inscripcion);
    }

    @ApiOperation(value = "Verifica si una persona esta inscrita en cierto taller")
    @GetMapping("/persona/{idp}/taller/{idt}")
    public ResponseEntity<Boolean> isInscrito(@PathVariable Long idp, @PathVariable Long idt) {
        return ResponseEntity.ok(inscripcionService.isInscrito(idp, idt));
    }

    @ApiOperation(value = "Crea una inscripcion")
    @PostMapping("/save")
    public Inscripcion save(@RequestBody Inscripcion inscripcion) {
        return inscripcionService.save(inscripcion);
    }

    @ApiOperation(value = "Modifica una inscripcion")
    @PutMapping("/update")
    public Inscripcion update(@RequestBody Inscripcion inscripcion) {
        return inscripcionService.save(inscripcion);
    }

    @ApiOperation(value = "Elimina una inscripcion")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        inscripcionService.deleteById(id);
    }

    @ApiOperation(value = "Elimina una inscripcion por Persona y Taller")
    @GetMapping("/delete/persona/{idp}/taller/{idt}")
    public void deleteInscripcionByPersonaTaller(@PathVariable Long idp, @PathVariable Long idt) {
        inscripcionService.deleteInscripcionByPersonaTaller(idp, idt);
    }
}
