package sbz.projekat.dto;

import org.kie.api.runtime.KieSession;

import java.io.Serializable;

public class SesijaDTO implements Serializable {

    private KieSession session;

    public SesijaDTO() {
    }

    public KieSession getSession() {
        return session;
    }

    public void setSession(KieSession session) {
        this.session = session;
    }
}
