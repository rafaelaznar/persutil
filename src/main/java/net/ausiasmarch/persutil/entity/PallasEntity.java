package net.ausiasmarch.persutil.entity;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "notas")
public class PallasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 255)
    private String titulo;

    @NotNull
    @Size(min = 3)
    private String contenido;
    
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss ", shape = JsonFormat.Shape.STRING)
    private Date fechaCreacion;
    

    
}