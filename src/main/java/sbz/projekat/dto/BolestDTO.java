package sbz.projekat.dto;

import java.util.List;

public class BolestDTO {

    private String naziv;

    private List<Long> specificni;

    private List<Long> opsti;

    public BolestDTO() { }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public List<Long> getSpecificni() {
        return specificni;
    }

    public void setSpecificni(List<Long> specificni) {
        this.specificni = specificni;
    }

    public List<Long> getOpsti() {
        return opsti;
    }

    public void setOpsti(List<Long> opsti) {
        this.opsti = opsti;
    }
}
