package sbz.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbz.projekat.dodatno.Converter;
import sbz.projekat.dto.BolestDTO;
import sbz.projekat.model.Bolest;
import sbz.projekat.repostory.BolestRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BolestService {

    @Autowired
    private BolestRepository bRepo;

    public List<Bolest> getAll(){
        List<Bolest> bolesti = new ArrayList<>();
        bRepo.findAll().forEach(bolesti::add);
        return bolesti;
    }

    public Bolest getOne(String naziv){
        return bRepo.findByNaziv(naziv);
    }


    public Bolest addBolest(BolestDTO b){
        Bolest bol= Converter.convertBolest(b);
        if(bol!=null)
            bol = bRepo.save(bol);

        return bol;
    }


    public void removeBolest(Long id){
        Bolest b = new Bolest();
        b.setId(id);
        bRepo.delete(b);
    }

    public Bolest editBolest(BolestDTO b, Long id){
        Bolest bol= Converter.convertBolest(b);
        if(bol!=null && id>0){
            bol.setId(id);
            bol = bRepo.save(bol);
        }
        return bol;
    }

}
