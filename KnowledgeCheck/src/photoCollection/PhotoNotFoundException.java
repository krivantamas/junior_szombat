package photoCollection;

public class PhotoNotFoundException extends RuntimeException {
	public PhotoNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
