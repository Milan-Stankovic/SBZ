package sbz.projekat.service;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbz.projekat.dodatno.Converter;
import sbz.projekat.dto.TerapijaDTO;
import sbz.projekat.model.Terapija;
import sbz.projekat.repostory.TerapijaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TerapijaService {

    @Autowired
    private TerapijaRepository tRepo;

    public List<Terapija> getAll(){
        List<Terapija> s = new ArrayList<>();
        tRepo.findAll().forEach(s::add);
        return s;
    }

    public List<Terapija> getTerapijaByLekar(Long lekar){
        return tRepo.findByIzdaoLekarId(lekar);
    }

    public Terapija getOne(Long id){

        Terapija t = null;

        Optional<Terapija> op = tRepo.findById(id);
        if(op.isPresent()){
            t= op.get();
        }
        return t;
    }

    public List<Terapija> getTerapijaByPacijent(Long pacijent){
        return tRepo.findByPrimioId(pacijent);
    }

    public void removeTerapija(Long id){
        Terapija t = new Terapija();
        t.setId(id);
        tRepo.delete(t);
    }

    public Terapija addTerapija(TerapijaDTO t){
        Terapija t2 = Converter.convertTerapija(t);
        if(t2 != null)
            t2 = tRepo.save(t2);

        return t2;
    }


    public Terapija editTerapija(TerapijaDTO t, Long id){

        Terapija t2 = Converter.convertTerapija(t);
        if(t2 != null){
            t2.setId(id);
            t2 = tRepo.save(t2);
        }

        return t2;

    }

}
