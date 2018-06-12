package sbz.projekat.dto;

import sbz.projekat.model.Bolest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SveBolestiDTO implements Serializable {

    private ArrayList<String> bolesti = new ArrayList<>();

    public ArrayList<String> getBolesti() {
        return bolesti;
    }

    public void setBolesti(ArrayList<String> bolesti) {
        this.bolesti = bolesti;
    }

    public SveBolestiDTO() {
    }
}
