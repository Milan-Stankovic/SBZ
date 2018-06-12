package sbz.projekat.dto;

public class MonitorDTO {


    private String gusenjePoruka ="";

    private String dializaPoruka ="";

    private String srckaPoruka ="";

    private String poruka;

    public MonitorDTO() {
    }

    public String getGusenjePoruka() {
        return gusenjePoruka;
    }

    public void setGusenjePoruka(String gusenjePoruka) {
        this.gusenjePoruka = gusenjePoruka;
    }

    public String getDializaPoruka() {
        return dializaPoruka;
    }

    public void setDializaPoruka(String dializaPoruka) {
        this.dializaPoruka = dializaPoruka;
    }

    public String getSrckaPoruka() {
        return srckaPoruka;
    }

    public void setSrckaPoruka(String srckaPoruka) {
        this.srckaPoruka = srckaPoruka;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }
}
