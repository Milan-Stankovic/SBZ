package sbz.projekat.dto;

import java.util.List;

public class LekDTO {

    private String naziv;

    private String tip;

    private List<Long> sastojci;

    public LekDTO() {
    }

    public List<Long> getSastojci() {
        return sastojci;
    }

    public void setSastojci(List<Long> sastojci) {
        this.sastojci = sastojci;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
