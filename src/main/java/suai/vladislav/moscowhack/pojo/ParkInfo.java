package suai.vladislav.moscowhack.pojo;

public class ParkInfo{
	private String image;
	private int defaultZoom;
	private String defaultCoord;
	private String subname;
	private String description;
	private int pos;
	private double price;
	private String name;
	private String geometry;
	private String id;
	private Object purposeOfVisit;
	private Object cuts;
	private Object ticketName;

	public String getImage(){
		return image;
	}

	public int getDefaultZoom(){
		return defaultZoom;
	}

	public String getDefaultCoord(){
		return defaultCoord;
	}

	public String getSubname(){
		return subname;
	}

	public String getDescription(){
		return description;
	}

	public int getPos(){
		return pos;
	}

	public double getPrice(){
		return price;
	}

	public String getName(){
		return name;
	}

	public String getGeometry(){
		return geometry;
	}

	public String getId(){
		return id;
	}

	public Object getPurposeOfVisit(){
		return purposeOfVisit;
	}

	public Object getCuts(){
		return cuts;
	}

	public Object getTicketName(){
		return ticketName;
	}
}
