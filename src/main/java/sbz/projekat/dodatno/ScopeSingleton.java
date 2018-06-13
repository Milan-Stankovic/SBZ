package sbz.projekat.dodatno;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ScopeSingleton {

    private HashMap<Long, KieSession> sesije = new HashMap<>();

    public ScopeSingleton() {
    }

    public HashMap<Long, KieSession> getSesije() {
        return sesije;
    }

    public void setSesije(HashMap<Long, KieSession> sesije) {
        this.sesije = sesije;
    }
}
