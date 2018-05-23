package sbz.projekat.repostory;

import org.springframework.data.repository.CrudRepository;
import sbz.projekat.model.Lek;

public interface LekRepository  extends CrudRepository<Lek, Long> {
}
