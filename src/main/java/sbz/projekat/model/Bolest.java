package sbz.projekat.model;

import sbz.projekat.model.enums.TipBolesti;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Bolest implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany
    private List<Simptom> specificni;

    @ManyToMany
    private List<Simptom> opsti;

    private String naziv;

    public Bolest() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public List<Simptom> getSpecificni() {
        return specificni;
    }

    public void setSpecificni(List<Simptom> specificni) {
        this.specificni = specificni;
    }

    public List<Simptom> getOpsti() {
        return opsti;
    }

    public void setOpsti(List<Simptom> opsti) {
        this.opsti = opsti;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
