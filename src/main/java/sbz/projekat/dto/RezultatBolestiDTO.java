package sbz.projekat.dto;

import sbz.projekat.model.Bolest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RezultatBolestiDTO implements Serializable {

    private ArrayList<Bolest> bolesti = new ArrayList<>();

    public ArrayList<Bolest> getBolesti() {
        return bolesti;
    }

    public void setBolesti(ArrayList<Bolest> bolesti) {
        this.bolesti = bolesti;
    }

    public RezultatBolestiDTO() {
    }
}
