package ok.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by OKK on 07.08.2016.
 */
@Entity
public class Exhibit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String description;
    @Column
    private String timePeriod;
    @Column
    private String material;
    @Column
    private String origin;
    @Column
    @Lob
    private byte[] miniature = new byte[1];
    @ManyToOne (fetch = FetchType.EAGER)
    private Branch branch;
    @OneToMany (mappedBy = "exhibit", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ExhibitImage> exhibitImageList;

    @Override
    public String toString() {
        return "Exhibit{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", timePeriod='" + timePeriod + '\'' +
                ", material='" + material + '\'' +
                ", origin='" + origin + '\'' +
                ", miniature=" + Arrays.toString(miniature) +
                ", branch=" + branch +
                ", exhibitFotoList=" + exhibitImageList +
                '}';
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTimePeriod() {
        return this.timePeriod;
    }

    public void setTimePeriod(String timePeriod) {
        this.timePeriod = timePeriod;
    }

    public String getMaterial() {
        return this.material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public byte[] getMiniature() {
        return this.miniature;
    }

    public void setMiniature(byte[] miniature) {
        this.miniature = miniature;
    }

    public Branch getBranch() {
        return this.branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public List<ExhibitImage> getExhibitImageList() {
        return this.exhibitImageList;
    }

    public void setExhibitImageList(List<ExhibitImage> exhibitImageList) {
        this.exhibitImageList = exhibitImageList;
    }

    public Exhibit() {

    }
}
