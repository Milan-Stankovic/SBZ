package sbz.projekat.repostory;

import org.springframework.data.repository.CrudRepository;
import sbz.projekat.model.IstorijaBolesti;

import java.util.List;

public interface IstorijaBolestiRepository  extends CrudRepository<IstorijaBolesti, Long> {
}

