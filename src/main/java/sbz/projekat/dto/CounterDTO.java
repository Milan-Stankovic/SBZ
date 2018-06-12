package sbz.projekat.dto;

import org.kie.api.definition.type.PropertyReactive;

import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@PropertyReactive
public class CounterDTO {

    private HashMap<String, Integer> vrednosti = new HashMap<>();

    private int naj1 = -1;

    private int naj2 = -1;

    private int naj3 = -1;

    public CounterDTO() {
    }

    public HashMap<String, Integer> getVrednosti() {
        return vrednosti;
    }

    public void setVrednosti(HashMap<String, Integer> vrednosti) {
        this.vrednosti = vrednosti;
    }

    public int getNaj1() {
        return naj1;
    }

    public void setNaj1(int naj1) {
        this.naj1 = naj1;
    }

    public int getNaj2() {
        return naj2;
    }

    public void setNaj2(int naj2) {
        this.naj2 = naj2;
    }

    public int getNaj3() {
        return naj3;
    }

    public void setNaj3(int naj3) {
        this.naj3 = naj3;
    }

    public boolean checkDane(Date d1, Date d2, int n ){
        boolean b = false;

        long diff = d1.getTime() - d2.getTime();
        long i = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        if(i<n)
            b=true;

        return b;
    }

    public boolean check6m(Date d1, Date d2 ){
        boolean b = false;
        long diff = d1.getTime() - d2.getTime();
        long i = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        if(i>180)
            b=true;
        return b;
    }



}
