package sbz.projekat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sbz.projekat.model.*;
import sbz.projekat.model.enums.TipKorisnika;
import sbz.projekat.model.enums.TipLeka;
import sbz.projekat.repostory.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Calendar;
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
        Korisnik doktor2 = addUser(TipKorisnika.LEKAR, "doca", "doca", "Marko","Markovic");
        Korisnik doktor3 = addUser(TipKorisnika.LEKAR, "a", "a", "Nikola","Nikolic");


        Simptom s = addSimptom("CURENJE IZ NOSA");
        Simptom s2 = addSimptom("BOL U GRLU");
        Simptom s3 = addSimptom("GLAVOBOLJA");
        Simptom s4 = addSimptom("KIJANJE");
        Simptom s5 = addSimptom("KASALJ");


        Simptom s6 = addSimptom("TEMPERATURA VECA OD 38C");
        Simptom s7 = addSimptom("DRHTAVICA");

        Simptom s8 = addSimptom("BOL KOJI SE SIRI DO USIJU");
        Simptom s9 = addSimptom("TEMPERATURA VECA OD 40C DO 41C");
        Simptom s10 = addSimptom("GUBITAK APETITA");
        Simptom s11 = addSimptom("UMOR");
        Simptom s12 = addSimptom("ZUTI SEKRET IZ NOSA");

        Simptom s13 = addSimptom("OTICANJE OKO OCIJU");

        Simptom s14 = addSimptom("BOLOVAO OD PREHLADE ILI GROZNICE U ZADNJIH 60 DANA");

        Simptom s15 = addSimptom("U 6 MESECI 10 SLUCAJEVA VISOKOG PRITISKA");

        Simptom s16 = addSimptom("VISOK PRITISAK");

        Simptom s17 = addSimptom("CESTO URINIRANJE");
        Simptom s18 = addSimptom("GUBITAK TELESNE TEZINE");
        Simptom s19 = addSimptom("MUCNINA I POVRACANJE");
        Simptom s20 = addSimptom("ZAMOR");

        Simptom s21 = addSimptom("NOCTURIA");
        Simptom s22 = addSimptom("OTICANJE NOGU I ZGLOBOVA");
        Simptom s23 = addSimptom("GUSENJE");
        Simptom s24 = addSimptom("BOL U GRUDIMA");
        Simptom s25 = addSimptom("BOLUJE OD HIPERTENZIJE VISE OD 6 MESECI");
        Simptom s26 = addSimptom("BOLUJE OD DIJABETESA");
        Simptom s27 = addSimptom("DIJAREJA");

        Simptom s28 = addSimptom("OPERACIJA");

        Simptom s29 = addSimptom("OPORAVLJA SE OD OPERACIJE");
        Simptom s30 = addSimptom("POVISENA TEMPERATURA U POSLEDNJIH 14 DANA");
        Simptom s31 = addSimptom("PRIMAO ANTIBIOTIKE U POSLEDNJIH 21 DAN");


        List<Simptom> opstiAkutna = new ArrayList<>();
        opstiAkutna.add(s20);
        opstiAkutna.add(s23);
        opstiAkutna.add(s22);
        opstiAkutna.add(s27);

        List<Simptom> specificniAkutna = new ArrayList<>();
        specificniAkutna.add(s29);
        specificniAkutna.add(s30);
        specificniAkutna.add(s31);


        List<Simptom> opstiHronicna = new ArrayList<>();
        opstiHronicna.add(s20);
        opstiHronicna.add(s21);
        opstiHronicna.add(s22);
        opstiHronicna.add(s23);
        opstiHronicna.add(s24);

        List<Simptom> specificniHronicna = new ArrayList<>();

        specificniHronicna.add(s25);
        specificniHronicna.add(s26);

        List<Simptom> opstiDijabetes = new ArrayList<>();
        opstiDijabetes.add(s17);
        opstiDijabetes.add(s18);
        opstiDijabetes.add(s19);
        opstiDijabetes.add(s20);

        List<Simptom> opstiHipertenzija = new ArrayList<>();
        opstiHipertenzija.add(s15);

        List<Simptom> opstiInfekcija = new ArrayList<>();
        opstiInfekcija.add(s13);
        opstiInfekcija.add(s3);
        opstiInfekcija.add(s12);
        opstiInfekcija.add(s2);
        opstiInfekcija.add(s6);
        opstiInfekcija.add(s5);
        opstiInfekcija.add(s14);



        List<Simptom> opstiPrehlada = new ArrayList<>();
        opstiPrehlada.add(s);
        opstiPrehlada.add(s2);
        opstiPrehlada.add(s3);
        opstiPrehlada.add(s4);
        opstiPrehlada.add(s5);

        List<Simptom> opstiGroznica = new ArrayList<>();
        opstiGroznica.add(s4);
        opstiGroznica.add(s2);
        opstiGroznica.add(s5);
        opstiGroznica.add(s6);
        opstiGroznica.add(s);
        opstiGroznica.add(s3);
        opstiGroznica.add(s7);


        List<Simptom> opstiUpalaKrajnika = new ArrayList<>();

        opstiUpalaKrajnika.add(s2);
        opstiUpalaKrajnika.add(s8);
        opstiUpalaKrajnika.add(s3);
        opstiUpalaKrajnika.add(s9);
        opstiUpalaKrajnika.add(s7);
        opstiUpalaKrajnika.add(s10);
        opstiUpalaKrajnika.add(s11);
        opstiUpalaKrajnika.add(s12);


       List<Simptom> prazna = new ArrayList<>();

        List<Simptom> opsti2 = new ArrayList<>();
        opsti2.add(s3);
        List<Simptom> specificni2 = new ArrayList<>();
        specificni2.add(s5);

        Bolest prehlada = addBolest("PREHLADA", opstiPrehlada, prazna);
        Bolest groznica = addBolest("GROZNICA", opstiGroznica, prazna);
        Bolest upala_krajnika = addBolest("UPALA KRAJNIKA", opstiUpalaKrajnika, prazna);
        Bolest sinusna_infekcija = addBolest("SINUSNA INFEKCIJA", opstiInfekcija, prazna);

        Bolest hipertenzija = addBolest("HIPERTENZIJA", opstiHipertenzija, prazna);
        Bolest dijabetes = addBolest("DIJABETES", opstiDijabetes, prazna);

        Bolest hronicna_bubrezna_bolest = addBolest("HRONICNA BUBREZNA BOLEST", opstiHronicna, specificniHronicna);
        Bolest akutna_bubrezna_povreda = addBolest("AKUTNA BUBREZNA POVREDA", opstiDijabetes, prazna);



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



        Pacijent pac1 = addPacijent("Zoran", "Prehlada", "001", false);

        Pacijent pac2 = addPacijent("Tanja", "Groznica", "007", true);

        Pacijent pac3 = addPacijent("Marko", "Pritisak", "005", false);

        Pacijent pac4 = addPacijent("Nina", "Hipertenzija", "010", true);
        Pacijent pac5 = addPacijent("Sasa", "Dijabetes", "099", false);

        Pacijent pac6 = addPacijent("Jovana", "Temperatura", "063", true);
        Pacijent pac7 = addPacijent("Ilija", "Antibiotik", "016", false);

        Pacijent pac8 = addPacijent("Ana", "Zdrava", "000", false);

        Pacijent pac9 = addPacijent("Milan", "Hronicni", "061", true);

        Pacijent pac10 = addPacijent("Sanja", "Zavisnik", "071", false);

        Pacijent pac11 = addPacijent("Dragan", "Imunitet", "100", false);


        List<Lek> prazanLek = new ArrayList<>();
        List<Lek> antibiotik = new ArrayList<>();
        antibiotik.add(l2);

        List<Lek> analgetik = new ArrayList<>();
        analgetik.add(l);


        //IstorijaBolesti addIstorijaBolesti(List<Lek> terpije, List<Simptom> simptomi, List<Bolest> bolesti){

        List<Bolest> prehladaL = new ArrayList<>();

        prehladaL.add(prehlada);

        List<Bolest> praznaBolest = new ArrayList<>();

        List<Bolest> groznicaL = new ArrayList<>();

        groznicaL.add(groznica);

        List<Simptom> visokPritisakL = new ArrayList<>();

        visokPritisakL.add(s16);
        visokPritisakL.add(s16);
        visokPritisakL.add(s16);
        visokPritisakL.add(s16);
        visokPritisakL.add(s16);
        visokPritisakL.add(s16);
        visokPritisakL.add(s16);
        visokPritisakL.add(s16);
        visokPritisakL.add(s16);
        visokPritisakL.add(s16);
        visokPritisakL.add(s16);


        List<Bolest> hipertenzijaL = new ArrayList<>();

        hipertenzijaL.add(hipertenzija);

        List<Bolest> dijabetesL = new ArrayList<>();

        dijabetesL.add(dijabetes);

        List<Bolest> temperaturaL = new ArrayList<>();

        temperaturaL.add(groznica);

        IstorijaBolesti praznaIstorja = addIstorijaBolesti(prazanLek, prazna,praznaBolest , false, doktor );

        IstorijaBolesti analgetikIstorija = addIstorijaBolesti(analgetik, prazna,praznaBolest , false, doktor );
        IstorijaBolesti analgetikIstorija2 = addIstorijaBolesti(analgetik, prazna,praznaBolest , false, doktor2 );
        IstorijaBolesti analgetikIstorija3 = addIstorijaBolesti(analgetik, prazna,praznaBolest , false, doktor3 );

        IstorijaBolesti prehladaIstorija = addIstorijaBolesti(prazanLek, prazna,prehladaL , false, doktor );

        IstorijaBolesti antibiotikImunitet = addIstorijaBolesti(antibiotik, prazna,prehladaL , false, doktor );
        IstorijaBolesti antibiotikImunitet2 = addIstorijaBolesti(antibiotik, prazna,groznicaL , false, doktor );

        IstorijaBolesti groznicaIstorija = addIstorijaBolesti(prazanLek, prazna,groznicaL , false, doktor );

        IstorijaBolesti visokPritisakIstorija = addIstorijaBolesti(prazanLek, visokPritisakL, praznaBolest, false, doktor );

        IstorijaBolesti hipertenzijaIstorija = addIstorijaBolesti(prazanLek, prazna, hipertenzijaL, true, doktor );

        IstorijaBolesti dijabetesIstorija = addIstorijaBolesti(prazanLek, prazna, dijabetesL, false, doktor );

        IstorijaBolesti antibiotikIstorija = addIstorijaBolesti(antibiotik, prazna, groznicaL, false, doktor );

        pac1 = updatePacijentIstorija(prehladaIstorija, pac1);
        pac2 = updatePacijentIstorija(groznicaIstorija, pac2);
        pac3 = updatePacijentIstorija(visokPritisakIstorija, pac3);
        pac4 = updatePacijentIstorija(hipertenzijaIstorija, pac4);
        pac5 = updatePacijentIstorija(dijabetesIstorija, pac5);
        pac6 = updatePacijentIstorija(groznicaIstorija, pac6);
        pac7 = updatePacijentIstorija(antibiotikIstorija, pac7);
        pac8 = updatePacijentIstorija(praznaIstorja, pac8);

        pac9 = updatePacijentIstorija(dijabetesIstorija, pac9);
        pac9 = updatePacijentIstorija(dijabetesIstorija, pac9);
        pac9 = updatePacijentIstorija(dijabetesIstorija, pac9);
        pac9 = updatePacijentIstorija(dijabetesIstorija, pac9);
        pac9 = updatePacijentIstorija(dijabetesIstorija, pac9);
        pac9 = updatePacijentIstorija(dijabetesIstorija, pac9);


        pac10 = updatePacijentIstorija(analgetikIstorija, pac10);
        pac10 = updatePacijentIstorija(analgetikIstorija, pac10);
        pac10 = updatePacijentIstorija(analgetikIstorija, pac10);
        pac10 = updatePacijentIstorija(analgetikIstorija2, pac10);
        pac10 = updatePacijentIstorija(analgetikIstorija2, pac10);
        pac10 = updatePacijentIstorija(analgetikIstorija3, pac10);
        pac10 = updatePacijentIstorija(analgetikIstorija3, pac10);

        pac11 = updatePacijentIstorija(antibiotikImunitet, pac11);
        pac11 = updatePacijentIstorija(antibiotikImunitet, pac11);
        pac11 = updatePacijentIstorija(antibiotikImunitet, pac11);
        pac11 = updatePacijentIstorija(antibiotikImunitet, pac11);
        pac11 = updatePacijentIstorija(antibiotikImunitet, pac11);
        pac11 = updatePacijentIstorija(antibiotikImunitet, pac11);
        pac11 = updatePacijentIstorija(antibiotikImunitet, pac11);
        pac11 = updatePacijentIstorija(antibiotikImunitet2, pac11);
        pac11 = updatePacijentIstorija(antibiotikImunitet, pac11);
        pac11 = updatePacijentIstorija(antibiotikImunitet, pac11);
        pac11 = updatePacijentIstorija(antibiotikImunitet2, pac11);


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

    public IstorijaBolesti addIstorijaBolesti(List<Lek> terpije, List<Simptom> simptomi, List<Bolest> bolesti, boolean b, Korisnik k){
        IstorijaBolesti i = new IstorijaBolesti();


        Date d = new Date();

        if(b) {
            Calendar myCal = Calendar.getInstance();
            myCal.set(Calendar.YEAR, 2017);
            myCal.set(Calendar.MONTH, 6);
            myCal.set(Calendar.DAY_OF_MONTH, 1);
            d = myCal.getTime();
        }


        i.setDoktor(k);
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
