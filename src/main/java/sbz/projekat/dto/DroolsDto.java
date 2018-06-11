package sbz.projekat.dto;

import sbz.projekat.model.IstorijaBolesti;

import java.io.Serializable;
import java.util.List;

public class DroolsDto implements Serializable {

    private List<String> simptomi;

    private List<IstorijaBolesti> istorija;

    public DroolsDto() {
    }

    public List<String> getSimptomi() {
        return simptomi;
    }

    public void setSimptomi(List<String> simptomi) {
        this.simptomi = simptomi;
    }

    public List<IstorijaBolesti> getIstorija() {
        return istorija;
    }

    public void setIstorija(List<IstorijaBolesti> istorija) {
        this.istorija = istorija;
    }
}
