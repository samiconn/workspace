import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.exception.FacebookException;
import com.restfb.types.FacebookType;
import com.restfb.types.Page;
import com.restfb.types.User;

/**
 *
 * @author dsfounis
 */
public class FaceBookConnector {

    /* Variables */
    private final static String userAccessToken = "CAAWzuKHHiZAcBAG4ghmmRxvXjFLkrlcgaZBKrU9N8mIZAifVXmwahcTy2Ajn04rfAXXvdSAVt6cG0Ujv1ZCGEYZAnX3UsEUNZBtzi6JQCTFVdM6gr6CzjY6CZAjw8IpEYde1yXPlTmQcQqGjD9ZBjXnYZBCwRrRdF43Clj3r5C93rLuZAC64Lk1ax7V1wnhblC5mZCqAmQYOF8WzQZDZD";
    private final static String userID = "122899174721004 : John Tran";
    private static FacebookClient fbClient;
    private static User myuser = null;    //Store references to myr user and page
    private static Page mypage = null;    //for later use. In this question's context, these
                                   //references are useless.
    private static int counter = 0;

    @SuppressWarnings("deprecation")
	public static void FaceBookConnector() {
        try {

            fbClient = new DefaultFacebookClient(userAccessToken);
            myuser = fbClient.fetchObject("me", User.class);
            //mypage = fbClient.fetchObject(userID, Page.class);
            counter = 0;
        } catch (FacebookException ex) {     //So that you can see what went wrong
            ex.printStackTrace(System.err);  //in case you did anything incorrectly
        }
    }

    public static void makeTestPost() {
        fbClient.publish("me/feed", FacebookType.class, Parameter.with("message", Integer.toString(counter) + ": Hello, facebook World!"));
        counter++;
    }
    public static void searchUser() {
    	
    	
    	
    }
    public static void main(String[] args){
    	
    	FaceBookConnector();
    	makeTestPost();
    	
    	
    
    }

}