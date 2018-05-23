package sbz.projekat.repostory;

import org.springframework.data.repository.CrudRepository;
import sbz.projekat.model.Pacijent;

public interface PacijentRepository  extends CrudRepository<Pacijent, Long> {
}
