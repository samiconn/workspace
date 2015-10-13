import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class getXML
{
public static void main(String args[])
{
URL ourURL=null;
HttpURLConnection huc = null;
try {
ourURL = new URL("http://sohoa.vnexpress.net/tin-tuc/san-pham/may-tinh-bang/surface-pro-4-ra-mat-voi-man-hinh-12-3-inch-gia-tu-899-usd-3291605.html");
huc = (HttpURLConnection)ourURL.openConnection();
huc.setRequestMethod("GET");
try{
huc.connect();
}catch(Exception es){
es.printStackTrace();
System.out.println("Exception "+es.getMessage());
System.out.println("RESPONSE CODE"+huc.getResponseCode());
Thread.sleep(2000);
huc.connect();
}
BufferedReader reader = new BufferedReader(new InputStreamReader(huc.getInputStream()));

String line = null;
while ((line = reader.readLine()) != null) {
System.out.println(line);
}
}
catch(IOException ioe)
{
//ioe.printStackTrace();
}
catch(Exception e)
{
System.err.println("General Exception " + e);
e.printStackTrace();
}
}
} 