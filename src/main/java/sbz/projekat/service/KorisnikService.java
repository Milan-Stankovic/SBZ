package sbz.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sbz.projekat.dodatno.Converter;
import sbz.projekat.dto.KorisnikDTO;
import sbz.projekat.model.Korisnik;
import sbz.projekat.repostory.KorisnikRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class KorisnikService {

    @Autowired
    private KorisnikRepository korRepo;

    public Korisnik addKorisnik(KorisnikDTO kor){
        Korisnik k = Converter.converterKorisnika(kor);
        if(k != null)
            k= korRepo.save(k);
        return k;
    }

    public Korisnik edit(KorisnikDTO kor, Long id){
        Korisnik k = Converter.converterKorisnika(kor);
        if(k != null && id > 0){
            k.setId(id);
            k= korRepo.save(k);
        }
        return k;
    }

    public Korisnik getByUsernameKorisnik(String username){
        return korRepo.findByUsername(username);
    }

    public List<Korisnik> getByLastName(String prezime){
        return korRepo.findByPrezime(prezime);
    }

    public List<Korisnik> getByFirstNameAndLastName(String ime, String prezime){
        return korRepo.findByImeAndPrezime(ime, prezime);
    }

    public Korisnik getById(Long id){
        Optional<Korisnik> tu = korRepo.findById(id);
        Korisnik k = null;
        if(tu.isPresent())
            k = tu.get();
        return k;
    }

    public List<Korisnik> getAll(){
        List<Korisnik> korisnici = new ArrayList<>();
        korRepo.findAll().forEach(korisnici::add);
        return korisnici;
    }

    public void removeKorisnik(Long id){
        Korisnik k = new Korisnik();
        k.setId(id);
        korRepo.delete(k);
    }



}
