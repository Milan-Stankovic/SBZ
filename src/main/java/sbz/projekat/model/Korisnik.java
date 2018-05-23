package sbz.projekat.model;

import sbz.projekat.model.enums.TipKorisnika;

import javax.persistence.*;

@Entity
public class Korisnik {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;

    private String ime;

    private String prezime;

    @Enumerated(EnumType.STRING)
    private TipKorisnika tip;

    public Korisnik() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public TipKorisnika getTip() {
        return tip;
    }

    public void setTip(TipKorisnika tip) {
        this.tip = tip;
    }
}
