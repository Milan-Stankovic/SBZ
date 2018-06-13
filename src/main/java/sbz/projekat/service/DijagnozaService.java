package sbz.projekat.service;

import org.drools.core.time.SessionPseudoClock;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbz.projekat.dto.*;
import sbz.projekat.model.Bolest;
import sbz.projekat.model.Pacijent;

import sbz.projekat.repostory.BolestRepository;
import sbz.projekat.repostory.PacijentRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;


@Service
public class DijagnozaService {

    @Autowired
    private PacijentRepository pRepo;

    @Autowired
    private BolestRepository bRepo;

    private static Logger log = LoggerFactory.getLogger(DijagnozaService.class);

    private final KieContainer kieContainer;

    @Autowired
    public DijagnozaService(KieContainer kieContainer) {
        log.info("Initialising a new example session.");
        this.kieContainer = kieContainer;
    }

    private ArrayList<Bolest> converter(ArrayList<String> s){
        ArrayList<Bolest> bolesti = new ArrayList<>();

        for (String temp:s) {
            Bolest b = bRepo.findByNaziv(temp);
            if(b!=null){
                bolesti.add(b);
                System.out.println(temp);
            }
        }

        return bolesti;
    }

    public RezultatBolestiDTO najverovatnije(DijagnozaDTO d) {


        RezultatBolestiDTO r = new RezultatBolestiDTO();
        SveBolestiDTO bolesti = new SveBolestiDTO();


        Date dat = new Date();

        DroolsDto dto = new DroolsDto();
        dto.setSimptomi(d.getSimptomi());
        Optional<Pacijent> op = pRepo.findById(d.getKorisnik());

        CounterDTO c = new CounterDTO();

        if(op.isPresent()){
            KieSession kieSession = kieContainer.newKieSession("cepKsession");
            dto.setIstorija(op.get().getIstorija());

            kieSession.insert(dat);
            kieSession.insert(c);
            kieSession.insert(dto);
            kieSession.getAgenda().getAgendaGroup("najverovatnije").setFocus();
            kieSession.setGlobal("bolesti", bolesti);
            kieSession.fireAllRules();
            kieSession.dispose();
            bolesti= (SveBolestiDTO) kieSession.getGlobal("bolesti");



            r.setBolesti(converter(bolesti.getBolesti()));


        }

        return r;
    }

    public RezultatSimptomiDTO bolest(SimptomiDTO naziv){
        RezultatSimptomiDTO rezultat = new RezultatSimptomiDTO();


        KieSession kieSession = kieContainer.newKieSession("cepKsession");
        kieSession.getAgenda().getAgendaGroup("bolest").setFocus();




        kieSession.insert(naziv.getNaziv());

        kieSession.setGlobal("sviSimptomi", rezultat);



        kieSession.fireAllRules();
        kieSession.dispose();

        rezultat =(RezultatSimptomiDTO) kieSession.getGlobal("sviSimptomi");

        return rezultat;
    }

    public List<Bolest> sve(DijagnozaDTO d) {


        SveBolestiDTO bolesti = new SveBolestiDTO();


        Date dat = new Date();
        CounterDTO c = new CounterDTO();
        DroolsDto dto = new DroolsDto();
        dto.setSimptomi(d.getSimptomi());
        Optional<Pacijent> op = pRepo.findById(d.getKorisnik());
        if(op.isPresent()){
            KieSession kieSession = kieContainer.newKieSession("cepKsession");
            kieSession.getAgenda().getAgendaGroup("sve").setFocus();
            kieSession.setGlobal("sveBolesti", bolesti);

            kieSession.insert(dat);

            kieSession.insert(dto);
            kieSession.insert(c);

            kieSession.fireAllRules();
            kieSession.dispose();

            bolesti= (SveBolestiDTO) kieSession.getGlobal("sveBolesti");
            return converter(bolesti.getBolesti());
        }
        return null;

    }

    public RezultatStringDTO validiraj(ValidacijaDTO dto) {
        KieSession kieSession = kieContainer.newKieSession("cepKsession");
        kieSession.getAgenda().getAgendaGroup("validacija").setFocus();

        RezultatStringDTO validiraj = new RezultatStringDTO();

        kieSession.setGlobal("validiraj", validiraj);

        kieSession.insert(dto);

        kieSession.fireAllRules();
        kieSession.dispose();

        validiraj=  (RezultatStringDTO) kieSession.getGlobal("validiraj");

        System.out.println("IZ VALIDACIJE : " + validiraj.getTekst());

        RezultatStringDTO r = new RezultatStringDTO();
        r.setTekst(validiraj.getTekst());
        return r;

    }


    public RezultatStringDTO monitor(){
        String s ="";

//        KieSessionConfiguration ksconf1 = kieContainer.getKieSessionConfiguration();
 //       ksconf1.setOption(ClockTypeOption.get(ClockType.PSEUDO_CLOCK.getId()));
        KieSession ksession1 = kieContainer.newKieSession("cepKsession");

        List<Pacijent> pacijenti = pRepo.findByMonitoring(true);

        int i = (int) Math.random() % pacijenti.size();

        Pacijent p= pacijenti.get(i);

        MonitorDTO ispis = new MonitorDTO();

        ksession1.setGlobal("ispis", ispis);

        ksession1.insert(p); // Zbog bubrezne


        SessionPseudoClock clock = ksession1.getSessionClock();
        for (int index = 0; index < 100; index++) {
            SrceEvent beep = new SrceEvent();
            ksession1.insert(beep);

            if(index%10 ==0)
                clock.advanceTime(1, TimeUnit.SECONDS);
            int ruleCount = ksession1.fireAllRules();
            //As long as there is a steady heart beat, no rule will fire
        }


        for (int index = 0; index < 6; index++) {
            KiseonikEvent disi = new KiseonikEvent();
            ksession1.insert(disi);

            //As long as there is a steady heart beat, no rule will fire
        }
        clock.advanceTime(16, TimeUnit.MINUTES);
        int ruleCount = ksession1.fireAllRules();

        if(ruleCount> 0)
            System.out.println("PROBLEM SA DISANJEM");



        for (int index = 0; index < 100; index++) {
            SrceEvent beep = new SrceEvent();
            ksession1.insert(beep);
            MokrenjeEvent e = new MokrenjeEvent();

            if(index%10 ==0)
                ksession1.insert(e);


            if(index%30 ==0)
                clock.advanceTime(1, TimeUnit.SECONDS);
             ruleCount = ksession1.fireAllRules();

            if(ruleCount >0){
                System.out.println("PROBLEM SA SRCEM");
            }


        }

        ispis = (MonitorDTO) ksession1.getGlobal("ispis");

        if( !ispis.getDializaPoruka().equals(""))
            s+=ispis.getDializaPoruka() + System.getProperty("line.separator");
        if( !ispis.getGusenjePoruka().equals(""))
            s+=ispis.getGusenjePoruka() + System.getProperty("line.separator");
        if( !ispis.getSrckaPoruka().equals(""))
            s+=ispis.getSrckaPoruka() + System.getProperty("line.separator");

        ksession1.dispose();


        RezultatStringDTO r = new RezultatStringDTO();
        r.setTekst(s);
        return r;

    }

    public RezultatIzvestajaDTO izvestaj() {
        KieSession kieSession = kieContainer.newKieSession("cepKsession");
        kieSession.getAgenda().getAgendaGroup("izvestaj").setFocus();

        DoktoriDTO doktori = new DoktoriDTO();


        ArrayList<Pacijent> svi = new ArrayList<>();
        pRepo.findAll().forEach(svi::add);

        IzvestajDTO i = new IzvestajDTO();

        Date d = new Date();
        kieSession.insert(d);
        kieSession.insert(doktori);

        kieSession.setGlobal("izvestaj",i );

        for (Pacijent p:svi) {
            kieSession.insert(p);
        }

        kieSession.fireAllRules();
        kieSession.dispose();
        i= (IzvestajDTO) kieSession.getGlobal("izvestaj");

        return izvestajConverter(i);

    }

    private RezultatIzvestajaDTO izvestajConverter( IzvestajDTO i){
        RezultatIzvestajaDTO r = new RezultatIzvestajaDTO();

        for (Long l: i.getZavisnici()) {
            Optional<Pacijent> op =pRepo.findById(l);
            if(op.isPresent()){
                Pacijent p = op.get();
                r.getZavisnici().add(p);
            }
        }

        for (Long l: i.getHronicni()) {
            Optional<Pacijent> op =pRepo.findById(l);
            if(op.isPresent()){
                Pacijent p = op.get();
                r.getHronicni().add(p);
            }
        }


        for (Long l: i.getImunitet()) {
            Optional<Pacijent> op =pRepo.findById(l);
            if(op.isPresent()){
                Pacijent p = op.get();
                r.getImunitet().add(p);
            }
        }


        return r;
    }


}
