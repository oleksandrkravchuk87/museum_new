package ok.repository;

import ok.entity.Exhibit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by OKK on 07.08.2016.
 */
public interface ExhibitRepo extends JpaRepository <Exhibit, Integer> {

    @Query("from Exhibit e where e.description LIKE :description")
    List<Exhibit> findByDesc (@Param("description") String description);


}
