package sbz.projekat.repostory;

import org.springframework.data.repository.CrudRepository;
import sbz.projekat.model.Terapija;

import java.util.List;

public interface TerapijaRepository  extends CrudRepository<Terapija, Long> {
    List<Terapija> findByIzdaoLekarId(Long id);
    List<Terapija> findByPrimioId(Long id);
}
