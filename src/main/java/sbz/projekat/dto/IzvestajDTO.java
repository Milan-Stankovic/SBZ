package sbz.projekat.dto;

import sbz.projekat.model.Pacijent;

import java.util.List;

public class IzvestajDTO {

    private List<Pacijent> hronicni;

    private List<Pacijent> zavisnici;

    private List<Pacijent> imunitet;

    public IzvestajDTO() {
    }

    public List<Pacijent> getHronicni() {
        return hronicni;
    }

    public void setHronicni(List<Pacijent> hronicni) {
        this.hronicni = hronicni;
    }

    public List<Pacijent> getZavisnici() {
        return zavisnici;
    }

    public void setZavisnici(List<Pacijent> zavisnici) {
        this.zavisnici = zavisnici;
    }

    public List<Pacijent> getImunitet() {
        return imunitet;
    }

    public void setImunitet(List<Pacijent> imunitet) {
        this.imunitet = imunitet;
    }
}
