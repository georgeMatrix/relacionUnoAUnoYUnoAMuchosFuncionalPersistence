package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Producto {
    private Long id;
    private String nombre;
    private String clave;
    private Integer precio;
    private Cliente clienteByIdCliente;

    @Id
    @Column(name = "id")
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
    @Column(name = "clave")
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Basic
    @Column(name = "precio")
    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(id, producto.id) &&
                Objects.equals(nombre, producto.nombre) &&
                Objects.equals(clave, producto.clave) &&
                Objects.equals(precio, producto.precio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, clave, precio);
    }

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id", nullable = false)
    public Cliente getClienteByIdCliente() {
        return clienteByIdCliente;
    }

    public void setClienteByIdCliente(Cliente clienteByIdCliente) {
        this.clienteByIdCliente = clienteByIdCliente;
    }
}
