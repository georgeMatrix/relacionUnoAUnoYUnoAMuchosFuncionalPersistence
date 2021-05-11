package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "datos_fiscales", schema = "producto-cliente-03052021", catalog = "")
public class DatosFiscales {
    private Integer id;
    private String rfc;
    private String curp;
    private Cliente clienteById;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "rfc")
    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    @Basic
    @Column(name = "curp")
    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatosFiscales that = (DatosFiscales) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(rfc, that.rfc) &&
                Objects.equals(curp, that.curp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rfc, curp);
    }

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    public Cliente getClienteById() {
        return clienteById;
    }

    public void setClienteById(Cliente clienteById) {
        this.clienteById = clienteById;
    }
}
