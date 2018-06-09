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

    @ManyToMany
    private List<Simptom> simptomi;

    @ManyToMany
    private List<Bolest> bolesti;

    @ManyToMany
    private List<Lek> terapija;

    public IstorijaBolesti() {
    }

    public List<Lek> getTerapije() {
        return terapija;
    }

    public void setTerapije(List<Lek> terapija) {
        this.terapija = terapija;
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
