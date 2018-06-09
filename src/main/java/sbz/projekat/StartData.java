package sbz.projekat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sbz.projekat.model.*;
import sbz.projekat.model.enums.TipKorisnika;
import sbz.projekat.model.enums.TipLeka;
import sbz.projekat.repostory.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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


        Simptom s = addSimptom("POVISENA TEMPERATURA");
        Simptom s2 = addSimptom("BOL U STOMAKU");
        Simptom s3 = addSimptom("POVISEN SECER");
        Simptom s4 = addSimptom("ZAMOR");
        Simptom s5 = addSimptom("NOCTURIA");
        Simptom s6 = addSimptom("GUSENJE");
        Simptom s7 = addSimptom("DIJABETES");

        List<Simptom> opsti = new ArrayList<>();
        opsti.add(s);
        opsti.add(s2);
        opsti.add(s4);
        List<Simptom> specificni = new ArrayList<>();
        specificni.add(s7);
        specificni.add(s6);

        List<Simptom> opsti2 = new ArrayList<>();
        opsti2.add(s3);
        List<Simptom> specificni2 = new ArrayList<>();
        specificni2.add(s5);

        Bolest b = addBolest("HRONICNA UPALA BUBREGA", opsti, specificni);
        Bolest b2 = addBolest("DIJABETES", opsti2, specificni2);

        List<Bolest> bolesti1 = new ArrayList<>();
        bolesti1.add(b);
        bolesti1.add(b2);

        List<Bolest> bolesti2 = new ArrayList<>();
        bolesti2.add(b);

        Sastojak sa1 = addSastojak("VODA");
        Sastojak sa2 = addSastojak("SECER");
        Sastojak sa3 = addSastojak("MLEKO");
        Sastojak sa4 = addSastojak("ANTIBIOTIK");
        Sastojak sa5 = addSastojak("SO"); // Kreativnost na novu

        List<Sastojak> lekOd = new ArrayList<>();
        lekOd.add(sa1);
        lekOd.add(sa5);
        lekOd.add(sa4);

        List<Sastojak> lekOd2 = new ArrayList<>();
        lekOd2.add(sa2);


        List<Sastojak> lekOd3 = new ArrayList<>();
        lekOd3.add(sa3);
        lekOd3.add(sa2);



        Lek l = addLek("Aspirin", lekOd, TipLeka.ANALGETIK);
        Lek l2 = addLek("Klindamicin", lekOd2, TipLeka.ANTIBOTIK);
        Lek l3 = addLek("Strepsils", lekOd3, TipLeka.OSTALO);

        List<Lek> lekovi = new ArrayList<>();
        lekovi.add(l);
        lekovi.add(l2);

        List<Lek> lekovi2 = new ArrayList<>();
        lekovi2.add(l3);



        Pacijent pac1 = addPacijent("Minja", "Car", "001", false);

        Pacijent pac2 = addPacijent("Milan", "Markovic", "007", true);

     /*   Terapija t1 = addTerapija(pac1, doktor, lekovi);

        Terapija t2 = addTerapija(pac2, doktor, lekovi2);

        List<Terapija> ter1 = new ArrayList<>();
        ter1.add(t1);
        ter1.add(t2);

        List<Terapija> ter2 = new ArrayList<>();
        ter2.add(t2);

*/
        IstorijaBolesti i = addIstorijaBolesti(lekovi, specificni, bolesti1);
        IstorijaBolesti i2 = addIstorijaBolesti(lekovi2, opsti, bolesti2);

        pac1= updatePacijentIstorija(i, pac1);

        pac1 = updatePacijentIstorija(i2, pac1);

        pac2 = updatePacijentIstorija(i2, pac2);

        pac1 = updatePacijentAlergije(lekOd, pac1);

        pac2 = updatePacijentAlergije(lekOd2, pac2);

    }

    public Pacijent updatePacijentAlergije(List<Sastojak> alergije, Pacijent p1){

        p1.setAlergije(alergije);
        return pRepo.save(p1);
    }

    public Pacijent updatePacijentIstorija(IstorijaBolesti i1, Pacijent p1){

        p1.getIstorija().add(i1);
        return pRepo.save(p1);
    }

    public IstorijaBolesti addIstorijaBolesti(List<Lek> terpije, List<Simptom> simptomi, List<Bolest> bolesti){
        IstorijaBolesti i = new IstorijaBolesti();

        Date d = new Date();
        i.setVreme(d);
        i.setTerapije(terpije);
        i.setSimptomi(simptomi);
        i.setBolesti(bolesti);
        return  iRepo.save(i);

    }



    public  Terapija addTerapija(Pacijent primio, Korisnik lekar, List<Lek> lekovi){
        Terapija t = new Terapija();

        t.setPrimio(primio);

        for (Lek l:lekovi) {
            System.out.println("Lek : " + l.getNaziv());

        }

        t.setLekovi(lekovi);
        t.setIzdaoLekar(lekar);

        t=tRepo.save(t);
        return t;
    }

    public Lek addLek(String naziv, List<Sastojak> sastojci, TipLeka tip){
        Lek l = new Lek();
        l.setNaziv(naziv);
        l.setSastojci(sastojci);
        l.setTip(tip);

        l= lRepo.save(l);
        return l;
    }

    public Sastojak addSastojak(String naziv){
        Sastojak s = new Sastojak();
        s.setNaziv(naziv);

        s=sRepo.save(s);
        return s;
    }

    public Bolest addBolest(String naziv, List<Simptom> opsti, List<Simptom> specificni){
        Bolest b = new Bolest();
        b.setSpecificni(specificni);
        b.setOpsti(opsti);
        b.setNaziv(naziv);

        b=bRepo.save(b);

        return b;
    }


    public Simptom addSimptom(String naziv){
        Simptom s = new Simptom();
        s.setNaziv(naziv);
        s=simRepo.save(s);
        return s;
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
