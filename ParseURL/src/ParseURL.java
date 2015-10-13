import java.io.*;
import java.net.*;

public class ParseURL {

	public static void main(String[] args) throws Exception {
		
		URL aURL =  new URL("https://www.facebook.com/109076526103269");
		
		System.out.println("Protocol: " + aURL.getProtocol());
		System.out.println("Authority: " + aURL.getAuthority());
		System.out.println("host: " + aURL.getHost());
		System.out.println("port: " + aURL.getPort());
		System.out.println("path: " + aURL.getPath());
		System.out.println("query: " + aURL.getQuery());
		System.out.println("filename: " + aURL.getFile());
		System.out.println("ref: " + aURL.getRef());

	}

}
