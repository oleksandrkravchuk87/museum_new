package ok.repository;

import ok.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by OKK on 07.08.2016.
 */
public interface EventRepo extends JpaRepository<Event, Integer> {
}
