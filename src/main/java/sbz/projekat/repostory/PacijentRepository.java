package sbz.projekat.repostory;

import org.springframework.data.repository.CrudRepository;
import sbz.projekat.model.Pacijent;

import java.util.List;

public interface PacijentRepository  extends CrudRepository<Pacijent, Long> {
    Pacijent findByBrojZdravstveneKartice(String s);
    List<Pacijent> findByMonitoring(boolean b);
    List<Pacijent> findByImeAndPrezime(String ime, String prezime);
}
