package sbz.projekat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sbz.projekat.model.IstorijaBolesti;
import sbz.projekat.model.Korisnik;
import sbz.projekat.model.Pacijent;
import sbz.projekat.model.Sastojak;
import sbz.projekat.model.enums.TipKorisnika;
import sbz.projekat.repostory.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Component
public class StartData {

    @Autowired
    private KorisnikRepository kRepo;

    @Autowired
    private PacijentRepository pRepo;

    @Autowired
    private SastojakRepository sRepo;

    @Autowired
    private BolestRepository bRepo;

    @Autowired
    private IstorijaBolestiRepository iRepo;

    @Autowired
    private LekRepository lRepo;

    @Autowired
    private SimptomRepository simRepo;

    @Autowired
    private TerapijaRepository tRepo;

    @PostConstruct
    public void addData(){
        Korisnik admin = addUser(TipKorisnika.ADMIN, "admin","admin","Admin","Adminovic");
        Korisnik doktor = addUser(TipKorisnika.LEKAR, "doc", "doc", "Doktor","Dokic");
        Pacijent pac1 = addPacijent("Minja", "Car", "001", false);
        Pacijent pac2 = addPacijent("Milan", "Markovic", "007", true);

    }

    public Pacijent addPacijent(String ime, String prezime, String zdr, boolean m){
        Pacijent p = new Pacijent();
        p.setMonitoring(m);
        p.setIme(ime);
        p.setPrezime(prezime);
        p.setBrojZdravstveneKartice(zdr);
        p.setIstorija(new ArrayList<IstorijaBolesti>());
        p.setAlergije(new ArrayList<Sastojak>());
        p = pRepo.save(p);
        return p;
    }

    public Korisnik addUser(TipKorisnika tip, String user, String pass, String ime, String prezime){
        Korisnik k = new Korisnik();
        k.setTip(tip);
        k.setPassword(pass);
        k.setUsername(user);
        k.setIme(ime);
        k.setPrezime(prezime);
        k= kRepo.save(k);
        return k;
    }

}
