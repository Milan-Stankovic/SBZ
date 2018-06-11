package sbz.projekat.dto;

import java.util.List;

public class DijagnozaDTO {

    private List<String> simptomi;

    private Long korisnik;

    public DijagnozaDTO() {
    }

    public List<String> getSimptomi() {
        return simptomi;
    }

    public void setSimptomi(List<String> simptomi) {
        this.simptomi = simptomi;
    }

    public Long getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Long korisnik) {
        this.korisnik = korisnik;
    }
}
