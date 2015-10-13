import java.net.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.text.*;
import javax.swing.text.html.*;
import javax.swing.text.html.parser.*;
import java.awt.image.*;

public class ExtrackAllImages {
    public static void main(String args[]) throws Exception {

        String webUrl = "https://www.facebook.com/nhatthong.thanha";
        URL url = new URL(webUrl);
        URLConnection connection = url.openConnection();
        InputStream is = connection.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        HTMLEditorKit htmlKit = new HTMLEditorKit();
        HTMLDocument htmlDoc = (HTMLDocument) htmlKit.createDefaultDocument();
        HTMLEditorKit.Parser parser = new ParserDelegator();
        HTMLEditorKit.ParserCallback callback = htmlDoc.getReader(0);
        parser.parse(br, callback, true);

        for (HTMLDocument.Iterator iterator = htmlDoc.getIterator(HTML.Tag.IMG); iterator.isValid(); iterator.next()) {
            AttributeSet attributes = iterator.getAttributes();
            String imgSrc = (String) attributes.getAttribute(HTML.Attribute.SRC);
            System.out.println(imgSrc);
            if (imgSrc != null && (imgSrc.endsWith(".jpg") || (imgSrc.endsWith(".png")) || (imgSrc.endsWith(".jpeg")) || (imgSrc.endsWith(".bmp")) || (imgSrc.endsWith(".gif")))) {
                try {
                	String filename = imgSrc.substring(imgSrc.lastIndexOf("/") + 1, imgSrc.length());
                	 System.out.println(filename);
                	downloadImage(imgSrc, filename);
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
    private static void downloadImage(String imgSrc, String filename) throws IOException {
    	/**
    	URL url = new URL(imgSrc);
		InputStream is = url.openStream();
		OutputStream os = new FileOutputStream(filename);

		byte[] b = new byte[2048];
		int length;

		while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);
		}

		is.close();
		os.close();
    	*/
    	
    	
    	BufferedImage image = null;
        try {
            
            //imgSrc = imgSrc.substring(imgSrc.lastIndexOf("/") + 1);
            String imageFormat = null;
            imageFormat = imgSrc.substring(imgSrc.lastIndexOf(".") + 1);
            String imgPath = null;
            imgPath = filename;
            URL imageUrl = new URL(imgSrc);
            image = ImageIO.read(imageUrl);
            if (image != null) {
                File file = new File(imgPath);
                ImageIO.write(image, imageFormat, file);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}