package sbz.projekat.dodatno;

import sbz.projekat.dto.BolestDTO;
import sbz.projekat.dto.KorisnikDTO;
import sbz.projekat.model.Bolest;
import sbz.projekat.model.Korisnik;
import sbz.projekat.model.Simptom;
import sbz.projekat.model.enums.TipKorisnika;

import java.util.ArrayList;

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
