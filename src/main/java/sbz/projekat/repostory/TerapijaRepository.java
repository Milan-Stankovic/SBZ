package sbz.projekat.repostory;

import org.springframework.data.repository.CrudRepository;
import sbz.projekat.model.Terapija;

public interface TerapijaRepository  extends CrudRepository<Terapija, Long> {
}
