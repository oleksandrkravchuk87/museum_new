package ok.dto;

/**
 * Created by OKK on 08.08.2016.
 */
public class EventDTO {
    private int id;
    private String name;

    private String description;

    private String passingDate;

    private String image;

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

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EventDTO() {

    }
}
