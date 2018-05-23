package sbz.projekat.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class IstorijaBolesti {


    @Id
    @GeneratedValue
    private Long id;

    private Date vreme;

    @OneToMany
    private List<Simptom> simptomi;

    @OneToMany
    private List<Bolest> bolesti;

    @OneToMany
    private List<Terapija> terapije;

    public IstorijaBolesti() {
    }

    public List<Terapija> getTerapije() {
        return terapije;
    }

    public void setTerapije(List<Terapija> terapije) {
        this.terapije = terapije;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getVreme() {
        return vreme;
    }

    public void setVreme(Date vreme) {
        this.vreme = vreme;
    }

    public List<Simptom> getSimptomi() {
        return simptomi;
    }

    public void setSimptomi(List<Simptom> simptomi) {
        this.simptomi = simptomi;
    }

    public List<Bolest> getBolesti() {
        return bolesti;
    }

    public void setBolesti(List<Bolest> bolesti) {
        this.bolesti = bolesti;
    }
}
