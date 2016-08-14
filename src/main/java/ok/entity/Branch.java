package ok.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;
/**
 * Created by OKK on 07.08.2016.
 */
@Entity
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String workingHours;
    @Column
    private String description;
    @Column
    @Lob
    private byte[] image = new byte[1];
@OneToMany(mappedBy = "branch", fetch = FetchType.LAZY)
    private List<Exhibit> exhibitList;
    @OneToMany(mappedBy ="branch", fetch = FetchType.LAZY)
    private List<Event> eventList;
    @OneToMany(mappedBy = "branch", fetch = FetchType.LAZY)
    private List<Employee> employeeList;
    @OneToMany(mappedBy = "branch", fetch = FetchType.LAZY)
    private List<Excursion> excursionList;

    @Override
    public String toString() {
        return "Branch{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", workingHours='" + workingHours + '\'' +
                ", description='" + description + '\'' +
                ", image=" + Arrays.toString(image) +
                ", exhibitList=" + exhibitList +
                ", eventList=" + eventList +
                ", employeeList=" + employeeList +
                ", excursionList=" + excursionList +
                '}';
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

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorkingHours() {
        return this.workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    public byte[] getImage() {
        return this.image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public List<Exhibit> getExhibitList() {
        return this.exhibitList;
    }

    public void setExhibitList(List<Exhibit> exhibitList) {
        this.exhibitList = exhibitList;
    }

    public List<Event> getEventList() {
        return this.eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    public List<Employee> getEmployeeList() {
        return this.employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Excursion> getExcursionList() {
        return this.excursionList;
    }

    public void setExcursionList(List<Excursion> excursionList) {
        this.excursionList = excursionList;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Branch() {

    }
}