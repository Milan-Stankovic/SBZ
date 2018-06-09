package sbz.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbz.projekat.dodatno.Converter;
import sbz.projekat.dto.SastojakDTO;
import sbz.projekat.model.Sastojak;
import sbz.projekat.repostory.SastojakRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SastojakService {

    @Autowired
    private SastojakRepository sRepo;

    public List<Sastojak> getAll(){
        List<Sastojak> s = new ArrayList<>();
        sRepo.findAll().forEach(s::add);
        return s;
    }

    public Sastojak getSastojak(String ime){
        return sRepo.findByNaziv(ime);
    }

    public void removeSastojak(Long id){
        Sastojak s = new Sastojak();
        s.setId(id);
        sRepo.delete(s);
    }

    public Sastojak getOneId(Long id){
        Sastojak s = null;

        Optional<Sastojak> op = sRepo.findById(id);
        if(op.isPresent()){
            s=op.get();

        }
        return s;
    }

    public Sastojak addSastojak(SastojakDTO s){
        Sastojak s2 = Converter.convertSastojka(s);
        if(s2 != null){
            Sastojak s3= sRepo.findByNaziv(s2.getNaziv());
            if(s3 == null){
                s2 = sRepo.save(s2);
            }
        }


        return s2;
    }


    public Sastojak editSastojak(SastojakDTO s, Long id){

        Sastojak s2 = Converter.convertSastojka(s);
        if(s2 != null){
            s2.setId(id);
            s2 = sRepo.save(s2);
        }

        return s2;

    }


}
