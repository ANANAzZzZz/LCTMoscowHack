package suai.vladislav.moscowhack.ecohack.route;

import com.fasterxml.jackson.annotation.JsonProperty;
import suai.vladislav.moscowhack.ecohack.park.ParkContacts;

import javax.persistence.*;

@Entity
@Table(name = "area")
public class Area {
    @Id
    @GeneratedValue
    private Integer id;

    private String image;
	private int defaultZoom;
	private String defaultCoord;
	private String subname;
    @Column(columnDefinition = "TEXT")
	private String description;
	private int pos;
	private float price;
	private String name;
    @Column(columnDefinition = "TEXT")
	private String geometry;
	private String purposeOfVisit;
    private String cuts;
    private String ticketName;

    @ManyToOne
    @JoinColumn(name = "contactsId")
    private ParkContacts parkContacts;

    @JsonProperty("id")
    private String areaId;

    @JsonProperty("id")
    public String getAreaId() {
        return areaId;
    }

    public ParkContacts getParkContacts() {
        return parkContacts;
    }

    public void setParkContacts(ParkContacts parkContacts) {
        this.parkContacts = parkContacts;
    }

    public String getTicketName() {
        return ticketName;
    }

    public String getCuts() {
        return cuts;
    }

    public String getPurposeOfVisit() {
        return purposeOfVisit;
    }

    public String getGeometry() {
        return geometry;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getPos() {
        return pos;
    }

    public String getDescription() {
        return description;
    }

    public String getSubname() {
        return subname;
    }

    public String getDefaultCoord() {
        return defaultCoord;
    }

    public int getDefaultZoom() {
        return defaultZoom;
    }

    public String getImage() {
        return image;
    }

    public Integer getId() {
        return id;
    }
}
