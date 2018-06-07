package sbz.projekat.repostory;

import org.springframework.data.repository.CrudRepository;
import sbz.projekat.model.Simptom;

public interface SimptomRepository  extends CrudRepository<Simptom, Long> {
    Simptom findByNaziv(String naziv);
}
