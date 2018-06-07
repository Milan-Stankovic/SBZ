package sbz.projekat.dto;

import java.util.List;

public class PacijentDTO {

    private String ime;

    private String prezime;

    private String brojZdravstveneKartice;

    private List<Long> alergije;

    public PacijentDTO() {
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

    public List<Long> getAlergije() {
        return alergije;
    }

    public void setAlergije(List<Long> alergije) {
        this.alergije = alergije;
    }
}
