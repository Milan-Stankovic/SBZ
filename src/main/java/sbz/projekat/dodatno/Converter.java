package sbz.projekat.dodatno;

import sbz.projekat.dto.*;
import sbz.projekat.model.*;
import sbz.projekat.model.enums.TipKorisnika;
import sbz.projekat.model.enums.TipLeka;

import java.util.ArrayList;
import java.util.Date;

public class Converter {

    private static boolean checkBolest(BolestDTO bolest){

        boolean b = false;
        if(bolest != null)
            if(bolest.getSpecificni() != null)
                if(bolest.getOpsti() != null)
                    if(bolest.getOpsti().size() >0 || bolest.getSpecificni().size() >0)
                        b=true;

        if(b){
            for (Long temp:bolest.getOpsti()) {
                if(temp<0){
                    b=false;
                }
            }
            for (Long temp:bolest.getSpecificni()) {
                if(temp<0){
                    b=false;
                }
            }

        }

        return b;

    }

    public static Bolest convertBolest(BolestDTO bolest){
        Bolest b = null;

        if(checkBolest(bolest)){
            b= new Bolest();
            b.setNaziv(b.getNaziv());

            ArrayList<Simptom> opsti = new ArrayList<>();
            ArrayList<Simptom> specificni = new ArrayList<>();


            for (Long temp:bolest.getOpsti()) {
               Simptom s = new Simptom();
               s.setId(temp);
               opsti.add(s);

            }


            for (Long temp:bolest.getSpecificni()) {
                Simptom s = new Simptom();
                s.setId(temp);
                specificni.add(s);

            }

            b.setOpsti(opsti);
            b.setSpecificni(specificni);


        }

        return b;
    }

    private static boolean checkLek(LekDTO l){
        boolean b =false;

        if(l.getNaziv() != null)
            if(l.getTip() != null)
                if(l.getTip().trim().length()>0)
                    if(l.getNaziv().trim().length()>0)
                        if(l.getSastojci() != null)
                            if(l.getSastojci().size()>0)
                                b=true;

        return b;
    }


    public static Lek convertLek(LekDTO l){
        Lek lek = null;

        if(checkLek(l)){
           lek= new Lek();
           lek.setNaziv(l.getNaziv());
           lek.setTip(TipLeka.valueOf(l.getTip()));
           ArrayList<Sastojak> sastojci = new ArrayList<>();


            for (Long temp:l.getSastojci()) {
                if(temp>0){
                    Sastojak s = new Sastojak();
                    s.setId(temp);
                    sastojci.add(s);
                }
            }
            lek.setSastojci(sastojci);

        }

        return lek;
    }



    private static boolean checkSastojak(SastojakDTO sa){
        boolean b = false;

        if(sa.getNaziv() != null)
            if(sa.getNaziv().trim().length()>0)
                b=true;

        return b;
    }

    public static Sastojak convertSastojka(SastojakDTO sa){
        Sastojak s = null;

        if(checkSastojak(sa)){
            s = new Sastojak();
            s.setNaziv(sa.getNaziv().toUpperCase());
        }
        return s;
    }


    private static boolean checkTerapije(TerapijaDTO t){
        boolean b= false;

        if(t.getPrimio() != null)
            if(t.getIzdao() != null)
                if(t.getIzdao() >0)
                    if(t.getPrimio() >0)
                        if(t.getLekovi() != null)
                            if(t.getLekovi().size() >0)
                                b=true;

        return b;
    }

    public static Terapija convertTerapija(TerapijaDTO t){

        Terapija ter = null;
        if(checkTerapije(t)){

            Korisnik k = new Korisnik();
            k.setId(t.getIzdao());
            Pacijent p = new Pacijent();
            p.setId(t.getPrimio());
            ArrayList<Lek> lekovi = new ArrayList<>();

            for (Long id: t.getLekovi()) {
                if(id>0){
                    Lek l = new Lek();
                    l.setId(id);
                    lekovi.add(l);
                }
            }

            ter= new Terapija();
            ter.setIzdaoLekar(k);
            ter.setPrimio(p);
            ter.setLekovi(lekovi);

        }

        return ter;

    }


    private static boolean checkSimptom(SimptomiDTO sim){
        boolean b = false;

        if(sim.getNaziv() != null)
            if(sim.getNaziv().trim().length()>0)
                b=true;

        return b;
    }

    public static Simptom convertSimptom(SimptomiDTO sim){
        Simptom s = null;

        if(checkSimptom(sim)){
            s = new Simptom();
            s.setNaziv(sim.getNaziv().toUpperCase());
        }
        return s;
    }

    private static boolean checkIstorija(IstorijaBolestiDTO ib){
        boolean b = false;

        if(ib.getBolesti() != null)
            if(ib.getSimptomi() != null)
                if(ib.getTerapije() != null)
                    b= true;

        return b;
    }

    public static IstorijaBolesti convertIstorija(IstorijaBolestiDTO ib){

        IstorijaBolesti is = null;

        if(checkIstorija(ib)){

            is = new IstorijaBolesti();

            ArrayList<Terapija> terapije = new ArrayList<>();
            ArrayList<Simptom> simptomi = new ArrayList<>();
            ArrayList<Bolest> bolesti = new ArrayList<>();

            for (Long id:ib.getTerapije()) {
                if(id>0){
                    Terapija t = new Terapija();
                    t.setId(id);
                    terapije.add(t);
                }

            }

            for (Long id:ib.getSimptomi()) {
                if(id>0){
                    Simptom s = new Simptom();
                    s.setId(id);
                    simptomi.add(s);
                }

            }


            for (Long id:ib.getBolesti()) {
                if(id>0){
                    Bolest b = new Bolest();
                    b.setId(id);
                    bolesti.add(b);
                }

            }

            is.setBolesti(bolesti);
            is.setSimptomi(simptomi);
            is.setTerapije(terapije);
            Date d = new Date();
            is.setVreme(d);
        }

        return is;
    }

    private static boolean checkPacijent(PacijentDTO pac){
        boolean b = false;

        if(pac.getBrojZdravstveneKartice() != null)
            if(pac.getIme() != null)
                if(pac.getPrezime() != null)
                    if(pac.getPrezime().trim().length()>0)
                        if(pac.getIme().trim().length()>0)
                            if(pac.getBrojZdravstveneKartice().length()>0)
                                b=true;
        return b;
    }

    public static Pacijent convertPacijent(PacijentDTO pac){
        Pacijent p = null;

        if(checkPacijent(pac)){
            p = new Pacijent();
            p.setIme(pac.getIme());
            p.setBrojZdravstveneKartice(pac.getBrojZdravstveneKartice());
            p.setPrezime(p.getPrezime());
            p.setMonitoring(false);
            ArrayList<Sastojak> alergije = new ArrayList<>();

            for (Long id:pac.getAlergije()) {
                if(id>0){
                    Sastojak s = new Sastojak();
                    s.setId(id);
                    alergije.add(s);
                }
            }
            p.setAlergije(alergije);
            ArrayList<IstorijaBolesti> istorijaBolesti = new ArrayList<>();
            p.setIstorija(istorijaBolesti);
        }
        return p;
    }

    private static boolean checkKorisnik(KorisnikDTO kor){
        boolean b = false;

        if(kor.getIme() !=null)
            if(kor.getPrezime() != null)
                if(kor.getPassword() != null)
                    if(kor.getTip() != null)
                        if(kor.getUsername() != null)
                            if(kor.getPassword().trim().length()>0)
                                if(kor.getTip().trim().length()>0)
                                    if(kor.getPrezime().trim().length()>0)
                                        if(kor.getIme().trim().length()>0)
                                            b=true;
        return b;
    }

    public static Korisnik converterKorisnika(KorisnikDTO kor){
        Korisnik k = null;

        if(checkKorisnik(kor)){
            k = new Korisnik();
            k.setIme(kor.getIme());
            k.setPrezime(kor.getPrezime());
            k.setUsername(kor.getUsername());
            k.setPassword(kor.getPassword());
            k.setTip(TipKorisnika.valueOf(kor.getTip()));
        }


        return k;
    }




}
