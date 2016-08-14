package ok.entity;

import javax.persistence.*;
import java.util.Arrays;

/**
 * Created by OKK on 07.08.2016.
 */
@Entity
public class ExhibitImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    @Lob
    private byte[] image = new byte[1];
    @ManyToOne (fetch = FetchType.LAZY)
    private Exhibit exhibit;

    public ExhibitImage() {
    }

    @Override
    public String toString() {
        return "ExhibitImage{" +
                "id=" + id +
                ", image=" + Arrays.toString(image) +
                ", exhibit=" + exhibit +
                '}';
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getimage() {
        return this.image;
    }

    public void setimage(byte[] image) {
        this.image = image;
    }

    public Exhibit getExhibit() {
        return this.exhibit;
    }

    public void setExhibit(Exhibit exhibit) {
        this.exhibit = exhibit;
    }
}
