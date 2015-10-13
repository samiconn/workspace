import java.net.*;
import java.io.*;

public class URLConnectionReader {

	public static void main(String[] args) throws Exception {
		
		URL url = new URL("http://vnexpress.net/tin-tuc/thoi-su/bo-khoa-hoc-cong-nghe-co-thu-truong-41-tuoi-3291531.html");
		URLConnection connection = url.openConnection();
		BufferedReader in = new BufferedReader(
				new InputStreamReader(connection.getInputStream()));
		
		String inputLine;
		
		while ((inputLine = in.readLine()) != null) {
			
			System.out.println(inputLine);
		}
		in.close();

	}

}