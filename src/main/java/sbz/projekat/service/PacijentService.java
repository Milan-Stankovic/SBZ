package sbz.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbz.projekat.dodatno.Converter;
import sbz.projekat.dto.IstorijaBolestiDTO;
import sbz.projekat.dto.PacijentDTO;
import sbz.projekat.dto.SastojakDTO;
import sbz.projekat.model.*;
import sbz.projekat.repostory.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacijentService {

    @Autowired
    private PacijentRepository pRepo;

    @Autowired
    private IstorijaBolestiRepository iRepo;

    @Autowired
    private SastojakRepository sRepo;



    public List<Pacijent> getAll(){
        List<Pacijent> pacijenti = new ArrayList<>();
        pRepo.findAll().forEach(pacijenti::add);
        return pacijenti;
    }

    public void addIstorija(IstorijaBolestiDTO idto, Long id){
        Pacijent p = new Pacijent();
        p.setId(id);

        IstorijaBolesti i = Converter.convertIstorija(idto);
        if(i != null){
            i = iRepo.save(i);
            p.getIstorija().add(i);
            pRepo.save(p);
        }
    }

    public void addAlergija(SastojakDTO al, Long id){

        Sastojak s = Converter.convertSastojka(al);
        if(s != null && id>0){
            s = sRepo.save(s);
            Pacijent p = new Pacijent();
            p.setId(id);
            p.getAlergije().add(s);

        }
    }


    public void addAlergijaId(Long al, Long id){

        if(al>0 && id >0){
            Sastojak s = new Sastojak();
            s.setId(al);
            Pacijent p = new Pacijent();
            p.setId(id);
            p.getAlergije().add(s);

        }
    }


    public List<Pacijent> getAllMonitoring(boolean b){
        return pRepo.findByMonitoring(b);
    }

    public List<Pacijent> getAllImePrezime(String ime, String prezime){
        return pRepo.findByImeAndPrezime(ime, prezime);
    }

    public Pacijent getPacijentZdravstvena(String brojZdravstvene){
        return pRepo.findByBrojZdravstveneKartice(brojZdravstvene);
    }

    public void removePacijent(Long id){
        Pacijent p = new Pacijent();
        p.setId(id);

         pRepo.delete(p);


    }

    public Pacijent addPacijent(PacijentDTO pac){
        Pacijent p = Converter.convertPacijent(pac);
        if(p != null)
            p = pRepo.save(p);

        return p;
    }

    public Pacijent getOne(Long id){
        Pacijent p = null;

        Optional<Pacijent> op = pRepo.findById(id);
        if(op.isPresent()){
            p=op.get();
        }

        return p;
    }


    public Pacijent editPacijent(PacijentDTO p, Long id){

        Pacijent pacijent = Converter.convertPacijent(p);
        if(pacijent != null){
            pacijent.setId(id);
            Optional<Pacijent> temp  = pRepo.findById(id);
            if(temp.isPresent()){
               Pacijent izmena = temp.get();
               pacijent.setIstorija(izmena.getIstorija());
               pacijent.setMonitoring(izmena.isMonitoring());
            }
            pacijent= pRepo.save(pacijent);
        }

        return pacijent;

    }
}
