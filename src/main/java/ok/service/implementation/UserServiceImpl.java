package ok.service.implementation;

import ok.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ok.repository.UserRepo;
import ok.service.UserService;

import javax.persistence.NoResultException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by OKK on 07.08.2016.
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    public void addOrEdit(User user) {
        if (user.getRole()!="ROLE_EMPLOYEE"){
            user.setRole("ROLE_USER");
        }
        LocalDateTime localDateTime =  LocalDateTime.now();
        Instant instant = localDateTime.toInstant(ZoneOffset.UTC);
        Date date = Date.from(instant);
        user.setRegistrationDate(date);
        userRepo.save(user);
    }
    public void delete(int id) {
userRepo.delete(id);
    }
    public User findOne(int id) {
        return userRepo.findOne(id);
    }
    public List<User> findAll() {
        return userRepo.findAll();
    }

    public UserDetails loadUserByUsername (String login) throws UsernameNotFoundException {
        User user;
        try {
            user=userRepo.findByLogin(login);
        } catch (NoResultException e) {
            return null;
        }
        Collection<SimpleGrantedAuthority> authorities=new ArrayList<SimpleGrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(String.valueOf(user.getRole())));
        return new org.springframework.security.core.userdetails.User(String.valueOf(user.getId()),user.getPassword(),authorities);
}}
