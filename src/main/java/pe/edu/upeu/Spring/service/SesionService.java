/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.upeu.Spring.service;

import java.util.List;

import pe.edu.upeu.Spring.entity.Sesion;

/**
 *
 * @author tpp
 */
public interface SesionService {

    public List<Sesion> findAll();

    public Sesion findById(Long id);

    public Sesion save(Sesion sesion);

    public List<Sesion> save4Default(Long idTaller);

    public void delete(Sesion sesion);

    public void deleteById(Long id);

    public List<Sesion> findByTallerId(Long id);

}
