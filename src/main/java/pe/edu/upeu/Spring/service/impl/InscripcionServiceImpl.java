/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.Spring.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.Spring.entity.Inscripcion;
import pe.edu.upeu.Spring.repository.InscripcionRepository;
import pe.edu.upeu.Spring.service.InscripcionService;

/**
 *
 * @author tpp
 */
@Service
public class InscripcionServiceImpl implements InscripcionService {

    @Autowired
    InscripcionRepository inscripcionRepository;

    @Override
    public List<Inscripcion> findAll() {
        return (List<Inscripcion>) inscripcionRepository.findAll();
    }

    @Override
    public Inscripcion findById(Long id) {
        return inscripcionRepository.findById(id).orElse(null);
    }

    @Override
    public Inscripcion save(Inscripcion inscripcion) {
        return inscripcionRepository.save(inscripcion);
    }

    @Override
    public void delete(Inscripcion inscripcion) {
        inscripcionRepository.delete(inscripcion);
    }

    @Override
    public void deleteById(Long id) {
        inscripcionRepository.deleteById(id);
    }

    @Override
    public boolean isInscrito(Long idPersona, Long idTaller) {
        boolean check = false;

        if(inscripcionRepository.isInscrito(idPersona, idTaller).size() > 0){
            check = true;
        }

        return check;
    }

    @Override
    public List<?> getCantidad() {
        return inscripcionRepository.getCantidad();
    }

    @Override
    public void deleteInscripcionByPersonaTaller(Long idPersona, Long idTaller) {
        inscripcionRepository.deleteInscripcion(idPersona, idTaller);
    }
}
