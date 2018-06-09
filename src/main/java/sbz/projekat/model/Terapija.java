package sbz.projekat.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Terapija {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany
    private List<Lek> lekovi;

    @ManyToOne
    private Korisnik izdaoLekar;

    @ManyToOne
    @JsonBackReference
    private Pacijent primio;

    public Terapija() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Lek> getLekovi() {
        return lekovi;
    }

    public void setLekovi(List<Lek> lekovi) {
        this.lekovi = lekovi;
    }

    public Korisnik getIzdaoLekar() {
        return izdaoLekar;
    }

    public void setIzdaoLekar(Korisnik izdaoLekar) {
        this.izdaoLekar = izdaoLekar;
    }

    public Pacijent getPrimio() {
        return primio;
    }

    public void setPrimio(Pacijent primio) {
        this.primio = primio;
    }
}
