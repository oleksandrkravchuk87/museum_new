package ok.repository;

import ok.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by OKK on 07.08.2016.
 */
public interface UserRepo extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.email LIKE :login OR u.phone LIKE :login")
    User findByLogin(@Param("login") String login);

}
