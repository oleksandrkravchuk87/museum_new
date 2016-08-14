package ok.entity;

import javax.persistence.*;

/**
 * Created by OKK on 07.08.2016.
 */
@Entity
public class ExcursionRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
private int id;
    @Column
    String excursionDay;
    @Column
    String excursionStart;

    @ManyToOne (fetch = FetchType.EAGER)
    private Excursion excursion;
    @ManyToOne (fetch = FetchType.EAGER)
    private User user;

    public ExcursionRecord() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Excursion getExcursion() {
        return this.excursion;
    }

    public void setExcursion(Excursion excursion) {
        this.excursion = excursion;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ExcursionRecord{" +
                "id=" + id +
                ", excursionDay='" + excursionDay + '\'' +
                ", excursionStart='" + excursionStart + '\'' +
                ", excursion=" + excursion +
                ", user=" + user +
                '}';
    }

    public String getExcursionDay() {
        return this.excursionDay;
    }

    public void setExcursionDay(String excursionDay) {
        this.excursionDay = excursionDay;
    }

    public String getExcursionStart() {
        return this.excursionStart;
    }

    public void setExcursionStart(String excursionStart) {
        this.excursionStart = excursionStart;
    }
}
