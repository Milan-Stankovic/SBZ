package sbz.projekat.dto;

import java.util.List;

public class TerapijaDTO {

    private List<Long> lekovi;

    private Long izdao;

    private Long primio;

    public TerapijaDTO() {
    }

    public List<Long> getLekovi() {
        return lekovi;
    }

    public void setLekovi(List<Long> lekovi) {
        this.lekovi = lekovi;
    }

    public Long getIzdao() {
        return izdao;
    }

    public void setIzdao(Long izdao) {
        this.izdao = izdao;
    }

    public Long getPrimio() {
        return primio;
    }

    public void setPrimio(Long primio) {
        this.primio = primio;
    }
}
