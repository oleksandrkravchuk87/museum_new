package ok.dto;

/**
 * Created by OKK on 08.08.2016.
 */
public class ExhibitDTO {

private int id;
    private String description;

    private String timePeriod;

    private String material;

    private String origin;

    private String miniature;

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

    public String getMiniature() {
        return this.miniature;
    }

    public void setMiniature(String miniature) {
        this.miniature = miniature;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ExhibitDTO() {

    }
}
