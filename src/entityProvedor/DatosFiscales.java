package entityProvedor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "datos_fiscales", schema = "producto-cliente-03052021", catalog = "")
public class DatosFiscales {
    private Long id;
    private String rfc;
    private String curp;
    private Integer bandera;
    private Provedor provedor;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Basic
    @Column(name = "bandera")
    public Integer getBandera() {
        return bandera;
    }

    public void setBandera(Integer bandera) {
        this.bandera = bandera;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatosFiscales that = (DatosFiscales) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(rfc, that.rfc) &&
                Objects.equals(curp, that.curp) &&
                Objects.equals(bandera, that.bandera);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rfc, curp, bandera);
    }

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    public Provedor getProvedor() {
        return provedor;
    }

    public void setProvedor(Provedor provedor) {
        this.provedor = provedor;
    }
}
