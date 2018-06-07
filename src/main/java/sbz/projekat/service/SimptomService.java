package sbz.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbz.projekat.dodatno.Converter;
import sbz.projekat.dto.SimptomiDTO;
import sbz.projekat.model.Simptom;
import sbz.projekat.repostory.SimptomRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimptomService {

    @Autowired
    private SimptomRepository sRepo;

    public List<Simptom> getAll(){
        List<Simptom> s = new ArrayList<>();
        sRepo.findAll().forEach(s::add);
        return s;
    }

    public Simptom getSimptom(String ime){
        return sRepo.findByNaziv(ime);
    }

    public void removeSimptom(Long id){
        Simptom s = new Simptom();
        s.setId(id);
        sRepo.delete(s);
    }

    public Simptom addSimptom(SimptomiDTO s){
        Simptom s2 = Converter.convertSimptom(s);
        if(s2 != null)
            s2 = sRepo.save(s2);

        return s2;
    }


    public Simptom editSimptom(SimptomiDTO s, Long id){

        Simptom s2 = Converter.convertSimptom(s);
        if(s2 != null){
            s2.setId(id);
            s2 = sRepo.save(s2);
        }

        return s2;

    }

}
