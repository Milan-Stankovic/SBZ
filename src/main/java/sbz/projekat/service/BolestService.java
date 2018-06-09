package sbz.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbz.projekat.dodatno.Converter;
import sbz.projekat.dto.BolestDTO;
import sbz.projekat.model.Bolest;
import sbz.projekat.repostory.BolestRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Bolest getOneId(Long id){
        Bolest b = null;

        Optional<Bolest> op = bRepo.findById(id);
        if(op.isPresent()){
            b=op.get();
        }

        return b;
    }


    public Bolest addBolest(BolestDTO b){
        Bolest bol= Converter.convertBolest(b);
        if(bol!=null){
            Bolest temp = bRepo.findByNaziv(bol.getNaziv());
            if(temp==null){
                bol = bRepo.save(bol);
            }

        }


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
            System.out.println(bol.getNaziv());

            bol.setId(id);
            bol = bRepo.save(bol);
        }
        return bol;
    }

}
