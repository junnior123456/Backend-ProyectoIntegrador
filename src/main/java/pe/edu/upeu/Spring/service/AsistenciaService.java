/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.upeu.Spring.service;

import java.util.List;

import pe.edu.upeu.Spring.entity.Asistencia;
import pe.edu.upeu.Spring.entity.Sesion;

/**
 *
 * @author tpp
 */
public interface AsistenciaService {

    public List<Asistencia> findAll();

    public Asistencia findById(Long id);

    public Asistencia save(Asistencia asistencia);

    public List<Asistencia> saveMany(List<Asistencia> list);

    public List<Asistencia> saveSesionPersona(List<Sesion> list, Long idp);

    public void delete(Asistencia asistencia);

    public void deleteById(Long id);

    public List<Asistencia> findBySesionId(Long id);

    public List<?> getEstadosByTaller();

    public void deleteByPersonaTaller(Long idPersona, Long idTaller);

}
