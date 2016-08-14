package ok.service;

import ok.entity.User;

import java.util.List;

/**
 * Created by OKK on 07.08.2016.
 */
public interface UserService {
    void addOrEdit (User user);
    void delete(int id);

    User findOne(int id);

    List<User> findAll();

}
