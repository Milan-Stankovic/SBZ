package sbz.projekat.model;

import sbz.projekat.model.enums.TipLeka;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Lek implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String naziv;

    private TipLeka tip;

    @ManyToMany
    private List<Sastojak> sastojci;

    public Lek() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public TipLeka getTip() {
        return tip;
    }

    public void setTip(TipLeka tip) {
        this.tip = tip;
    }

    public List<Sastojak> getSastojci() {
        return sastojci;
    }

    public void setSastojci(List<Sastojak> sastojci) {
        this.sastojci = sastojci;
    }
}
