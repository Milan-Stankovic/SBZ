package sbz.projekat.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pacijent {

    @Id
    @GeneratedValue
    private Long id;

    private String ime;

    private String prezime;

    private String brojZdravstveneKartice;


    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private List<IstorijaBolesti> istorija;

    @ManyToMany
    private List<Sastojak> alergije;

    private boolean monitoring;

    public Pacijent() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getBrojZdravstveneKartice() {
        return brojZdravstveneKartice;
    }

    public void setBrojZdravstveneKartice(String brojZdravstveneKartice) {
        this.brojZdravstveneKartice = brojZdravstveneKartice;
    }

    public List<IstorijaBolesti> getIstorija() {
        return istorija;
    }

    public void setIstorija(List<IstorijaBolesti> istorija) {
        this.istorija = istorija;
    }

    public List<Sastojak> getAlergije() {
        return alergije;
    }

    public void setAlergije(List<Sastojak> alergije) {
        this.alergije = alergije;
    }

    public boolean isMonitoring() {
        return monitoring;
    }

    public void setMonitoring(boolean monitoring) {
        this.monitoring = monitoring;
    }
}
