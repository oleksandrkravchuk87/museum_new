package ok.repository;

import ok.entity.ExcursionRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by OKK on 07.08.2016.
 */
public interface ExcursionRecordRepo extends JpaRepository<ExcursionRecord, Integer> {
    @Query("SELECT e FROM ExcursionRecord e WHERE e.user.id LIKE :id")
    List<ExcursionRecord> findByUser(@Param("id") int id);
}
