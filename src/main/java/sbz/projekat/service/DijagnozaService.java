package sbz.projekat.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbz.projekat.dto.*;
import sbz.projekat.model.Bolest;
import sbz.projekat.model.Korisnik;
import sbz.projekat.model.Pacijent;

import sbz.projekat.repostory.PacijentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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

    public ArrayList<Bolest> najverovatnije(DijagnozaDTO d) {


        ArrayList<Bolest> b = new ArrayList<>();
        SveBolestiDTO bolesti = new SveBolestiDTO();
        bolesti.setBolesti(b);

        DroolsDto dto = new DroolsDto();
        dto.setSimptomi(d.getSimptomi());
        Optional<Pacijent> op = pRepo.findById(d.getKorisnik());

        if(op.isPresent()){
            KieSession kieSession = kieContainer.newKieSession();
            dto.setIstorija(op.get().getIstorija());
            kieSession.setGlobal("bolesti", bolesti);

            kieSession.insert(dto);
            kieSession.getAgenda().getAgendaGroup("najverovatnije").setFocus();
            kieSession.fireAllRules();
            kieSession.dispose();
            bolesti= (SveBolestiDTO) kieSession.getGlobal("bolesti");
            return bolesti.getBolesti();
        }

        return null;
    }


    public List<Bolest> sve(DijagnozaDTO d) {

        ArrayList<Bolest> b = new ArrayList<>();
        SveBolestiDTO bolesti = new SveBolestiDTO();
        bolesti.setBolesti(b);


        DroolsDto dto = new DroolsDto();
        dto.setSimptomi(d.getSimptomi());
        Optional<Pacijent> op = pRepo.findById(d.getKorisnik());
        if(op.isPresent()){
            KieSession kieSession = kieContainer.newKieSession();

            kieSession.setGlobal("sveBolesti", bolesti);

            kieSession.insert(dto);
            kieSession.getAgenda().getAgendaGroup("sve").setFocus();
            kieSession.fireAllRules();
            kieSession.dispose();

            bolesti= (SveBolestiDTO) kieSession.getGlobal("sveBolesti");
            return bolesti.getBolesti();
        }
        return null;

    }

    public boolean validiraj(ValidacijaDTO dto) {
        KieSession kieSession = kieContainer.newKieSession();

        boolean b = false;

        kieSession.setGlobal("validiraj", b);

        kieSession.insert(dto);
        kieSession.getAgenda().getAgendaGroup("validacija").setFocus();
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
        kieSession.getAgenda().getAgendaGroup("izvestaj").setFocus();
        kieSession.fireAllRules();
        kieSession.dispose();
        return (IzvestajDTO) kieSession.getGlobal("izvestaj");

    }

}
