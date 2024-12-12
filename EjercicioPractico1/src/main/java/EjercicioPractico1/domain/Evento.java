package EjercicioPractico1.domain;


import jakarta.persistence.*;
import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table(name = "evento")  // Nombre de la tabla en la base de datos
public class Evento {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "tipo", nullable = false, length = 50)
    private String tipo;

    @Column(name = "fecha_inicio", nullable = false)
    private Date fechaInicio;

    @Column(name = "fecha_fin", nullable = false)
    private Date fechaFin;

    @Column(name = "capacidad", nullable = false)
    private Integer capacidad;

    // Constructor por defecto
    public Evento() {
    }

    // Constructor con parámetros
    public Evento(Long id, String nombre, String descripcion, String tipo, Date fechaInicio, Date fechaFin, Integer capacidad) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.capacidad = capacidad;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }
}
