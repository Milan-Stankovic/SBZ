package sbz.projekat.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbz.projekat.dto.DijagnozaDTO;
import sbz.projekat.dto.IzvestajDTO;
import sbz.projekat.model.Bolest;
import sbz.projekat.model.Pacijent;

import sbz.projekat.repostory.PacijentRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class DijagnozaService {

    @Autowired
    private PacijentRepository pRepo;

    private static Logger log = LoggerFactory.getLogger(DijagnozaService.class);

    private final KieContainer kieContainer;

    @Autowired
    public DijagnozaService(KieContainer kieContainer) {
        log.info("Initialising a new example session.");
        this.kieContainer = kieContainer;
    }

    public ArrayList<Bolest> najverovatnije(DijagnozaDTO dto) {
        KieSession kieSession = kieContainer.newKieSession();

        ArrayList<Bolest> bolesti = new ArrayList<>();

        kieSession.setGlobal("bolesti", bolesti);

        kieSession.insert(dto);
        kieSession.fireAllRules();
        kieSession.dispose();
        return (ArrayList<Bolest>) kieSession.getGlobal("sveBolesti");
    }


    public List<Bolest> sve(DijagnozaDTO dto) {
        KieSession kieSession = kieContainer.newKieSession();

        ArrayList<Bolest> bolesti = new ArrayList<>();

        kieSession.setGlobal("sveBolesti", bolesti);

        kieSession.insert(dto);
        kieSession.fireAllRules();
        kieSession.dispose();
        return  (ArrayList<Bolest>) kieSession.getGlobal("sveBolesti");
    }

    public boolean validiraj(DijagnozaDTO dto) {
        KieSession kieSession = kieContainer.newKieSession();

        boolean b = false;

        kieSession.setGlobal("validiraj", b);

        kieSession.insert(dto);
        kieSession.fireAllRules();
        kieSession.dispose();
        return  (boolean) kieSession.getGlobal("validiraj");
    }

    public IzvestajDTO izvestaj() {
        KieSession kieSession = kieContainer.newKieSession();

        List<Pacijent> svi = new ArrayList<>();
        pRepo.findAll().forEach(svi::add);

        IzvestajDTO i = new IzvestajDTO();

        kieSession.setGlobal("izvestaj",i );

        kieSession.insert(svi);
        kieSession.fireAllRules();
        kieSession.dispose();
        return (IzvestajDTO) kieSession.getGlobal("izvestaj");

    }

}
