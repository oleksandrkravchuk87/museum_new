package ok.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by OKK on 07.08.2016.
 */
@Entity
public class User {
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private String secondname;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private String password;
    @Transient
    private String passwordConfirm;
    @Column
    private String role;
    @Column
    @Temporal(TemporalType.DATE)
    private Date registrationDate;

    @OneToMany (fetch = FetchType.EAGER)
   private List<ExcursionRecord> excursionRecordList;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", secondname='" + secondname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", passwordConfirm='" + passwordConfirm + '\'' +
                ", role='" + role + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }

    public List<ExcursionRecord> getExcursionRecordList() {
        return this.excursionRecordList;
    }

    public void setExcursionRecordList(List<ExcursionRecord> excursionRecordList) {
        this.excursionRecordList = excursionRecordList;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondname() {
        return this.secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return this.passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getRegistrationDate() {
        return this.registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }




    public User() {

    }
}
