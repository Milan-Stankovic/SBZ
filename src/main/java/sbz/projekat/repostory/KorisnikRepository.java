package sbz.projekat.repostory;

import org.springframework.data.repository.CrudRepository;
import sbz.projekat.model.Korisnik;

public interface KorisnikRepository  extends CrudRepository<Korisnik, Long> {
}
