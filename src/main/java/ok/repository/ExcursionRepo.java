package ok.repository;

import ok.entity.Excursion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by OKK on 07.08.2016.
 */
public interface ExcursionRepo extends JpaRepository<Excursion, Integer> {
}
