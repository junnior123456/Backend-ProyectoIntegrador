/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.Spring.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.Spring.entity.Asistencia;
import pe.edu.upeu.Spring.entity.Persona;
import pe.edu.upeu.Spring.entity.Sesion;
import pe.edu.upeu.Spring.repository.AsistenciaRepository;
import pe.edu.upeu.Spring.repository.SesionRepository;
import pe.edu.upeu.Spring.service.AsistenciaService;

/**
 *
 * @author tpp
 */
@Service
public class AsistenciaServiceImpl implements AsistenciaService {

    @Autowired
    AsistenciaRepository asistenciaRepository;

    @Autowired
    SesionRepository sesionRepository;

    @Override
    public List<Asistencia> findAll() {
        return (List<Asistencia>) asistenciaRepository.findAll();
    }

    @Override
    public Asistencia findById(Long id) {
        return asistenciaRepository.findById(id).orElse(null);
    }

    @Override
    public Asistencia save(Asistencia asistencia) {
        return asistenciaRepository.save(asistencia);
    }

    @Override
    public void delete(Asistencia asistencia) {
        asistenciaRepository.delete(asistencia);
    }

    @Override
    public void deleteById(Long id) {
        asistenciaRepository.deleteById(id);
    }

    @Override
    public List<Asistencia> findBySesionId(Long id) {
        return asistenciaRepository.findBySesionId(id);
    }

    @Override
    public List<Asistencia> saveMany(List<Asistencia> list) {
        List<Asistencia> lAsistencias = new ArrayList<Asistencia>();
        for (int i = 0; i < list.size(); i++) {
            asistenciaRepository.save(list.get(i));
            lAsistencias.add(list.get(i));
        }
        return lAsistencias;
    }

    @Override
    public List<Asistencia> saveSesionPersona(List<Sesion> list, Long idp) {
        Persona persona = new Persona();
        persona.setId(idp);
        List<Asistencia> lAsistencias = new ArrayList<Asistencia>();
        for (int i = 0; i < list.size(); i++) {
            Asistencia asistencia = new Asistencia();
            asistencia.setEstado(0);
            asistencia.setPersona(persona);

            Sesion sesion = list.get(i);
            asistencia.setSesion(sesion);
            
            asistenciaRepository.save(asistencia);
            lAsistencias.add(asistencia);
        }
        return lAsistencias;
    }

    @Override
    public List<?> getEstadosByTaller() {
        return asistenciaRepository.getEstadosByTaller();
    }

    @Override
    public void deleteByPersonaTaller(Long idPersona, Long idTaller) {
        List<Sesion> lSesion = new ArrayList<Sesion>();
        lSesion = sesionRepository.findByTallerId(idTaller);
        for (int i = 0; i < lSesion.size(); i++) {
            asistenciaRepository.deleteByPersonaSesion(idPersona, lSesion.get(i).getId());
        }
    }

}
