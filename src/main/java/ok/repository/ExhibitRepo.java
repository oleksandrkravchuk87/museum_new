package ok.repository;

import ok.entity.Exhibit;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by OKK on 07.08.2016.
 */
public interface ExhibitRepo extends JpaRepository <Exhibit, Integer> {
}
