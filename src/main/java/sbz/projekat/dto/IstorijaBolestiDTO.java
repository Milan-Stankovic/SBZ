package sbz.projekat.dto;

import java.util.Date;
import java.util.List;

public class IstorijaBolestiDTO {

    private List<Long> simptomi;

    private List<Long> bolesti;

    private List<Long> terapije;

    public IstorijaBolestiDTO() {
    }

    public List<Long> getSimptomi() {
        return simptomi;
    }

    public void setSimptomi(List<Long> simptomi) {
        this.simptomi = simptomi;
    }

    public List<Long> getBolesti() {
        return bolesti;
    }

    public void setBolesti(List<Long> bolesti) {
        this.bolesti = bolesti;
    }

    public List<Long> getTerapije() {
        return terapije;
    }

    public void setTerapije(List<Long> terapije) {
        this.terapije = terapije;
    }
}
