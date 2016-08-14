package ok.entity;

import javax.persistence.*;
import java.util.Arrays;

/**
 * Created by OKK on 07.08.2016.
 */
@Entity
public class Event {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String passingDate;
    @Column
    @Lob
    private byte[] image = new byte[1];
    @ManyToOne (fetch = FetchType.LAZY)
    private Branch branch;

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", passingDate='" + passingDate + '\'' +
                ", image=" + Arrays.toString(image) +
                ", branch=" + branch +
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPassingDate() {
        return this.passingDate;
    }

    public void setPassingDate(String passingDate) {
        this.passingDate = passingDate;
    }

    public byte[] getImage() {
        return this.image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Branch getBranch() {
        return this.branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Event() {

    }
}
