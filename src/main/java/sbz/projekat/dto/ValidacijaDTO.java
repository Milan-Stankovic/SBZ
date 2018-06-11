package sbz.projekat.dto;

import java.util.ArrayList;

public class ValidacijaDTO {

    private ArrayList<String> alergije;

    private ArrayList<String> sastojci;

    public ArrayList<String> getAlergije() {
        return alergije;
    }

    public void setAlergije(ArrayList<String> alergije) {
        this.alergije = alergije;
    }

    public ArrayList<String> getSastojci() {
        return sastojci;
    }

    public void setSastojci(ArrayList<String> sastojci) {
        this.sastojci = sastojci;
    }

    public ValidacijaDTO() {
    }
}
