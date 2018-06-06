package sbz.projekat.repostory;

import org.springframework.data.repository.CrudRepository;
import sbz.projekat.model.Korisnik;

import java.util.List;

public interface KorisnikRepository  extends CrudRepository<Korisnik, Long> {
    Korisnik findByUsername(String user);
    List<Korisnik> findByIme(String user);
    List<Korisnik> findByImeAndPrezime(String ime, String prezime);
    List<Korisnik> findByPrezime(String prezime);
}
