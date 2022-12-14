package pe.edu.upeu.Spring.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "taller")
public class Taller {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tema")
    private String tema;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "lugar")
    private String lugar;

    @Column(name = "direccion")
    private String direccion;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "prog_id")
    private Programa programa;
}