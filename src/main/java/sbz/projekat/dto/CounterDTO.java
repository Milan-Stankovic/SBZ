package sbz.projekat.dto;

import java.util.HashMap;

public class CounterDTO {

    private HashMap<String, Integer> vrednosti;

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
}
