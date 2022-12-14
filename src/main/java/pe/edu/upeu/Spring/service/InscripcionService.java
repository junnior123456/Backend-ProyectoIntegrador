/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.upeu.Spring.service;

import java.util.List;
import pe.edu.upeu.Spring.entity.Inscripcion;

/**
 *
 * @author tpp
 */
public interface InscripcionService {

    public List<Inscripcion> findAll();

    public Inscripcion findById(Long id);

    public Inscripcion save(Inscripcion inscripcion);

    public void delete(Inscripcion inscripcion);

    public void deleteById(Long id);

    public boolean isInscrito(Long idPersona, Long idTaller);

    public List<?> getCantidad();

    public void deleteInscripcionByPersonaTaller(Long idPersona, Long idTaller);

}
