package sbz.projekat.dto;

import sbz.projekat.model.Bolest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SveBolestiDTO implements Serializable {

    private ArrayList<Bolest> bolesti;

    public ArrayList<Bolest> getBolesti() {
        return bolesti;
    }

    public void setBolesti(ArrayList<Bolest> bolesti) {
        this.bolesti = bolesti;
    }

    public SveBolestiDTO() {
    }
}
