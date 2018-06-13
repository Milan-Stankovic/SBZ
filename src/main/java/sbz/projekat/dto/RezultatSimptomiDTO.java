package sbz.projekat.dto;

import java.util.ArrayList;

public class RezultatSimptomiDTO {

    public ArrayList<String> specificni = new ArrayList<>();

    public ArrayList<String> opsti = new ArrayList<>();

    public ArrayList<String> getSpecificni() {
        return specificni;
    }

    public void setSpecificni(ArrayList<String> specificni) {
        this.specificni = specificni;
    }

    public ArrayList<String> getOpsti() {
        return opsti;
    }

    public void setOpsti(ArrayList<String> opsti) {
        this.opsti = opsti;
    }

    public RezultatSimptomiDTO() {
    }
}
