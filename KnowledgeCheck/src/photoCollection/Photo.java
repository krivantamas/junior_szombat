package photoCollection;

public class Photo implements Qualified {
	String name;
	Quality quality;
	
	public Photo(String name) {
		super();
		this.name = name;
		this.quality = Quality.NO_STAR;
	}
	
	public Photo(String name, Quality quality) {
		super();
		this.name = name;
		this.quality = quality;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public Quality getQuality() {
		return quality;
	}
	
	@Override
	public void setQuality(Quality quality) {
		this.quality = quality;
	}
	
	public Integer numberOfStars() {
		return switch(quality) {
			case ONE_STAR -> 1;
			case TWO_STARS -> 2;
			default -> 0;
			
		};
	}

}
