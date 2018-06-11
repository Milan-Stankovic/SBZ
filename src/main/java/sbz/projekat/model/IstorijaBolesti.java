package sbz.projekat.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class IstorijaBolesti implements Serializable {


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

    @ManyToOne
    private Korisnik doktor;

    public IstorijaBolesti() {
    }


    public Korisnik getDoktor() {
        return doktor;
    }

    public void setDoktor(Korisnik doktor) {
        this.doktor = doktor;
    }

    public List<Lek> getTerapija() {
        return terapija;
    }

    public void setTerapija(List<Lek> terapija) {
        this.terapija = terapija;
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
