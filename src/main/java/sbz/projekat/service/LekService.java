package sbz.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbz.projekat.dodatno.Converter;
import sbz.projekat.dto.LekDTO;
import sbz.projekat.model.Lek;
import sbz.projekat.repostory.LekRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class LekService {

    @Autowired
    private LekRepository lRepo;

    public List<Lek> getAll(){
        List<Lek> lekovi = new ArrayList<>();
        lRepo.findAll().forEach(lekovi::add);
        return lekovi;
    }

    public Lek getLek(String ime){
        return lRepo.findByNaziv(ime);
    }

    public void removeLek(Long id){
        Lek l = new Lek();
        l.setId(id);
        lRepo.delete(l);
    }

    public Lek addLek(LekDTO l){
        Lek lek = Converter.convertLek(l);
        if(lek != null)
            lek = lRepo.save(lek);

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