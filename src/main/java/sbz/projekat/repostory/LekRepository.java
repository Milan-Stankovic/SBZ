package sbz.projekat.repostory;

import org.springframework.data.repository.CrudRepository;
import sbz.projekat.model.Lek;
import sbz.projekat.model.enums.TipLeka;

import java.util.List;

public interface LekRepository  extends CrudRepository<Lek, Long> {
    Lek findByNaziv(String naziv);
    List<Lek> findByTip(TipLeka tip);
}
