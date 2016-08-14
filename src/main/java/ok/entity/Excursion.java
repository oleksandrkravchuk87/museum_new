package ok.entity;

import javax.persistence.*;
import java.util.List;
/**
 * Created by OKK on 07.08.2016.
 */
@Entity
public class Excursion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String excursionTheme;

    @Column
    private String excursionDuration;
    @ManyToOne (fetch = FetchType.EAGER)
    private Branch branch;

    @Column
    private String excursionDay;

    @Column
    private String excursionStart;

    @OneToMany (mappedBy = "excursion",fetch = FetchType.EAGER)
    private List<ExcursionRecord> excursionRecordList;

    @Override
    public String toString() {
        return "Excursion{" +
                "id=" + id +
                ", excursionTheme='" + excursionTheme + '\'' +
                ", excursionDuration='" + excursionDuration + '\'' +
                ", branch=" + branch +
                ", excursionDay='" + excursionDay + '\'' +
                ", excursionStart='" + excursionStart + '\'' +
                ", excursionRecordList=" + excursionRecordList +
                '}';
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExcursionTheme() {
        return this.excursionTheme;
    }

    public void setExcursionTheme(String excursionTheme) {
        this.excursionTheme = excursionTheme;
    }

    public String getExcursionDuration() {
        return this.excursionDuration;
    }

    public void setExcursionDuration(String excursionDuration) {
        this.excursionDuration = excursionDuration;
    }

    public Branch getBranch() {
        return this.branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
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

    public List<ExcursionRecord> getExcursionRecordList() {
        return this.excursionRecordList;
    }

    public void setExcursionRecordList(List<ExcursionRecord> excursionRecordList) {
        this.excursionRecordList = excursionRecordList;
    }

    public Excursion() {

    }
}
