/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.Spring.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.Spring.entity.Sesion;
import pe.edu.upeu.Spring.entity.Taller;
import pe.edu.upeu.Spring.repository.SesionRepository;
import pe.edu.upeu.Spring.service.SesionService;

/**
 *
 * @author tpp
 */
@Service
public class SesionServiceImpl implements SesionService {

    @Autowired
    SesionRepository sesionRepository;

    @Override
    public List<Sesion> findAll() {
        return (List<Sesion>) sesionRepository.findAll();
    }

    @Override
    public Sesion findById(Long id) {
        return sesionRepository.findById(id).orElse(null);
    }

    @Override
    public Sesion save(Sesion sesion) {
        return sesionRepository.save(sesion);
    }

    @Override
    public void delete(Sesion sesion) {
        sesionRepository.delete(sesion);
    }

    @Override
    public void deleteById(Long id) {
        sesionRepository.deleteById(id);
    }

    @Override
    public List<Sesion> findByTallerId(Long id) {
        return sesionRepository.findByTallerId(id);
    }

    @Override
    public List<Sesion> save4Default(Long idTaller) {
        List<Sesion> lSesiones = new ArrayList<Sesion>();
        for (int i = 0; i < 4; i++) {
            Sesion sesion = new Sesion();
            sesion.setNombre("Sesion "+(i+1));
            Taller taller = new Taller();
            taller.setId(idTaller);
            sesion.setTaller(taller);

            sesionRepository.save(sesion);
            lSesiones.add(sesion);
        }
        return lSesiones;
    }

}
