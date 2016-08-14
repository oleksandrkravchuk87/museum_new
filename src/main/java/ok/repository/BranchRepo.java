package ok.repository;

import ok.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by OKK on 07.08.2016.
 */
public interface BranchRepo extends JpaRepository<Branch, Integer> {
}
