package sbz.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbz.projekat.dodatno.Converter;
import sbz.projekat.dto.LekDTO;
import sbz.projekat.model.Lek;
import sbz.projekat.model.Sastojak;
import sbz.projekat.repostory.LekRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LekService {

    @Autowired
    private LekRepository lRepo;


    public List<Sastojak>  getSastojci(Long id){
        List<Sastojak> sastojci = new ArrayList<>();
        Lek l = getLekId(id);
        if(l != null)
            sastojci=l.getSastojci();

        return sastojci;
    }

    public List<Lek> getAll(){
        List<Lek> lekovi = new ArrayList<>();
        lRepo.findAll().forEach(lekovi::add);
        return lekovi;
    }

    public Lek getLek(String ime){
        return lRepo.findByNaziv(ime);
    }

    public Lek getLekId(Long id){
        Lek l = null;

        Optional<Lek> op = lRepo.findById(id);
        if(op.isPresent()){
            l=op.get();
        }

        return l;
    }


    public void removeLek(Long id){
        Lek l = new Lek();
        l.setId(id);
        lRepo.delete(l);
    }

    public Lek addLek(LekDTO l){
        Lek lek = Converter.convertLek(l);
        if(lek != null){

            Lek temp = lRepo.findByNaziv(lek.getNaziv());
            if(temp == null){
                lek = lRepo.save(lek);
            }
        }

        return lek;
    }


    public Lek editLek(LekDTO l, Long id){

        Lek lek = Converter.convertLek(l);
        if(lek != null){
            lek.setId(id);
            lek = lRepo.save(lek);
        }

        return lek;

    }


}
