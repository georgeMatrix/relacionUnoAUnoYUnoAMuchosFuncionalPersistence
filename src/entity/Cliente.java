package entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Cliente {
    private Long id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String email;
    private DatosFiscales datosFiscalesById;
    private List<Producto> productosById;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "apellido")
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Basic
    @Column(name = "edad")
    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id) &&
                Objects.equals(nombre, cliente.nombre) &&
                Objects.equals(apellido, cliente.apellido) &&
                Objects.equals(edad, cliente.edad) &&
                Objects.equals(email, cliente.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido, edad, email);
    }

    @OneToOne(mappedBy = "clienteById")
    public DatosFiscales getDatosFiscalesById() {
        return datosFiscalesById;
    }

    public void setDatosFiscalesById(DatosFiscales datosFiscalesById) {
        this.datosFiscalesById = datosFiscalesById;
    }

    @OneToMany(mappedBy = "clienteByIdCliente")
    public List<Producto> getProductosById() {
        return productosById;
    }

    public void setProductosById(List<Producto> productosById) {
        this.productosById = productosById;
    }
}
