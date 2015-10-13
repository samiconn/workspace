
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.ResponseList;
import twitter4j.Status;

import java.io.InputStream;

import twitter4j.Paging;

public class samfetchTwit {

	static String consumerKeyStr = "sqylgTZaiTTABAhnVGduE8KZf";
	static String consumerSecretStr = "oByIWaDYGEOwXokk5Zvd1alJ6Yf7eSRIpkcD6o13Xmn8HQgmkU";
	static String accessTokenStr = "60539486-bGGBhciOB4qaQcQO76kH7KC3Bp6ncaz5LDjLe6vdT";
	static String accessTokenSecretStr = "71xw70Hbuxht34OugzCPnBK81HDojac68TNSQgS1lpyxz";

	public static void main(String[] args) {
		
		Twitter twitter = new TwitterFactory().getInstance();
		
		
			

			twitter.setOAuthConsumer(consumerKeyStr, consumerSecretStr);
			AccessToken accessToken = new AccessToken(accessTokenStr,
					accessTokenSecretStr);

			twitter.setOAuthAccessToken(accessToken);
		/**
		try {
			twitter.updateStatus("Post using Twitter4J Again");

			System.out.println("Successfully updated the status in Twitter.");
		} catch (TwitterException te) {
			te.printStackTrace();
		}
		*/
		try {
			ResponseList<Status> a = twitter.getHomeTimeline(new Paging(1,20));
			
			for (Status b: a) {
				
				System.out.println(b.getText());
				System.out.println();
			}
				
			
		} catch( Exception e) {
			
		}
	}

}