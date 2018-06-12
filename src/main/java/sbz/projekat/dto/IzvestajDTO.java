package sbz.projekat.dto;

import sbz.projekat.model.Pacijent;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class IzvestajDTO {

    private List<Long> hronicni = new ArrayList<>();

    private List<Long> zavisnici= new ArrayList<>();

    private List<Long> imunitet = new ArrayList<>();

    public IzvestajDTO() {
    }

    public List<Long> getHronicni() {
        return hronicni;
    }

    public void setHronicni(List<Long> hronicni) {
        this.hronicni = hronicni;
    }

    public List<Long> getZavisnici() {
        return zavisnici;
    }

    public void setZavisnici(List<Long> zavisnici) {
        this.zavisnici = zavisnici;
    }

    public List<Long> getImunitet() {
        return imunitet;
    }

    public void setImunitet(List<Long> imunitet) {
        this.imunitet = imunitet;
    }

    public boolean checkDane(Date d1, Date d2, int n ){
        boolean b = false;

        long diff = d1.getTime() - d2.getTime();
        long i = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        if(i<n)
            b=true;

        return b;
    }
}
