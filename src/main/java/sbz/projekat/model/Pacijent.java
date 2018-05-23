package sbz.projekat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Pacijent {

    @Id
    @GeneratedValue
    private Long id;

    private String ime;

    private String prezime;

    private String brojZdravstveneKartice;

    @OneToMany
    private List<IstorijaBolesti> istorija;

    @OneToMany
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
