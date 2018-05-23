package sbz.projekat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Bolest {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private List<Simptom> specificni;

    @OneToMany
    private List<Simptom> opsti;

    private String naziv;

    public Bolest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
