import java.net.URISyntaxException;
import java.nio.file.Paths;

public class Test {
	
	public static void main(String[] args) throws URISyntaxException {
		System.out.println(Paths.get(ClassLoader.getSystemResource("Prices.txt").toURI()).toAbsolutePath());
	}

}
