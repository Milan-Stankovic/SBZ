package sbz.projekat.repostory;

import org.springframework.data.repository.CrudRepository;
import sbz.projekat.model.Sastojak;

public interface SastojakRepository  extends CrudRepository<Sastojak, Long> {
    Sastojak findByNaziv(String naziv);
}
