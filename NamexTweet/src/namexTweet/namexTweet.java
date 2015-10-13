package namexTweet;
 
import java.io.IOException;
 
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
 
public class namexTweet {
    private final static String CONSUMER_KEY = "sqylgTZaiTTABAhnVGduE8KZf";
    private final static String CONSUMER_KEY_SECRET = "oByIWaDYGEOwXokk5Zvd1alJ6Yf7eSRIpkcD6o13Xmn8HQgmkU";
 
    public void start() throws TwitterException, IOException {
 
    Twitter twitter = new TwitterFactory().getInstance();
    twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);
 
    // here's the difference
    String accessToken = getSavedAccessToken();
    String accessTokenSecret = getSavedAccessTokenSecret();
    AccessToken oathAccessToken = new AccessToken(accessToken,
        accessTokenSecret);
 
    twitter.setOAuthAccessToken(oathAccessToken);
    // end of difference
 
    //twitter.updateStatus("Hi, im updating status again from Namex Tweet for Demo");
 
    System.out.println("\nMy Timeline:");
 
    // I'm reading your timeline
    ResponseList<Status> list = twitter.getHomeTimeline();
    for (Status each : list) {
 
        System.out.println("Sent by: @" + each.getUser().getScreenName()
            + " - " + each.getUser().getName() + "\n" + each.getText()
            + "\n");
    }
 
    }
 
    private String getSavedAccessTokenSecret() {
    // consider this is method to get your previously saved Access Token
    // Secret
    return "71xw70Hbuxht34OugzCPnBK81HDojac68TNSQgS1lpyxz";
    }
 
    private String getSavedAccessToken() {
    // consider this is method to get your previously saved Access Token
    return "60539486-bGGBhciOB4qaQcQO76kH7KC3Bp6ncaz5LDjLe6vdT";
    }
 
    public static void main(String[] args) throws Exception {
    new namexTweet().start();
    }
 
}