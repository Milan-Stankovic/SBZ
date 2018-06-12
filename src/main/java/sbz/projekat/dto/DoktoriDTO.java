package sbz.projekat.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class DoktoriDTO implements Serializable {

    private ArrayList<Long> doktori = new ArrayList<>();

    public DoktoriDTO() {
    }

    public ArrayList<Long> getDoktori() {
        return doktori;
    }

    public void setDoktori(ArrayList<Long> doktori) {
        this.doktori = doktori;
    }
}
