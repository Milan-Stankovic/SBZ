package sbz.projekat.dto;

import sbz.projekat.model.Lek;

import java.util.ArrayList;

public class SviLekoviDTO {

    private Long id;

    private ArrayList<Lek> lekovi = new ArrayList<>();

    private ArrayList<Long> doktori = new ArrayList<>();

    public SviLekoviDTO() {
    }

    public ArrayList<Long> getDoktori() {
        return doktori;
    }

    public void setDoktori(ArrayList<Long> doktori) {
        this.doktori = doktori;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArrayList<Lek> getLekovi() {
        return lekovi;
    }

    public void setLekovi(ArrayList<Lek> lekovi) {
        this.lekovi = lekovi;
    }
}
