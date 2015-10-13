import java.net.*;
import java.io.*;

public class URLReader {

	public static void main(String[] args) throws Exception {
		
		URL url = new URL("http://sohoa.vnexpress.net/tin-tuc/san-pham/may-tinh-bang/surface-pro-4-ra-mat-voi-man-hinh-12-3-inch-gia-tu-899-usd-3291605.html");
		BufferedReader in = new BufferedReader(
				new InputStreamReader(url.openStream()));
		
		String inputLine;
		
		while ((inputLine = in.readLine()) != null) {
			
			System.out.println(inputLine);
		}
		in.close();

	}

}
