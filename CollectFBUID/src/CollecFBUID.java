import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

import facebook4j.Account;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Friendlist;
import facebook4j.IdNameEntity;
import facebook4j.Post;
import facebook4j.Reading;
import facebook4j.ResponseList;
import facebook4j.User;
import facebook4j.auth.AccessToken;
import facebook4j.internal.org.json.JSONArray;
import facebook4j.internal.org.json.JSONException;
import facebook4j.internal.org.json.JSONObject;

/**
 * 
 */

/**
 * @author samiconn
 *
 */
public class CollecFBUID {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	
	public static void searchUser(Facebook facebook) throws FacebookException, IOException, InterruptedException {
		File file =  new File("sample.txt");
		File fuid = new File("fuid.txt");
		int counter = 0;
		
		
		BufferedReader reader = new BufferedReader(new FileReader(file));
		
		while (true) {
			
			
				String line = reader.readLine();
				
			if (line == null)
			{
				break;
			}
			System.out.println(line);
			
			if (line.length() != 0) {
			ResponseList<User> results = facebook.searchUsers(line);
			BufferedWriter writer = new BufferedWriter(new FileWriter(fuid, true));
			for (int i = 0; i < results.size(); i++) {
				counter = counter+1;
				
				User us = results.get(i);
				String id = us.getId();
				String username = us.getName();
							
				System.out.println(counter+". "+ id +" "+" "+username);
				writer.append(id);
				writer.append("\r\n");
				
			}
			writer.close();
			}
			Random rd = new Random();
			int time = 1000*rd.nextInt(10);
			Thread.sleep(time);
		}
		
		reader.close();
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(fuid, true));
		writer.append(Integer.toString(counter));
		writer.close();
		
	}
	
	public static void getInfor(Facebook facebook, File file) throws IOException, FacebookException, JSONException {
				
		BufferedReader reader = new BufferedReader(new FileReader(file));
		
		
		while (true) {
			
			String line = reader.readLine();
			
			User results  = facebook.getUser(line);
			
			
			
			
			
			System.out.println(results.getUsername());
		}
		
	}
	public static String getFacebookPostes(Facebook facebook, String searchPost)
            throws FacebookException {
        String searchResult = "Item : " + searchPost + "\n";
        StringBuilder searchMessage = new StringBuilder();
        ResponseList<Post> results = facebook.getPosts(searchPost);

        //facebook.getFriends(new Reading().fields("gender"));
        //System.out.println("success");
        //System.out.println(facebook.getMe().getFirstName()); 

        String userId="";
        for (Post post : results) {
            System.out.println(post.getMessage());
            searchMessage.append(post.getMessage() + "\n");
            for (int j = 0; j < post.getComments().size(); j++) {
             searchMessage.append(post.getComments().get(j).getFrom()
                        .getName()
                        + ", ");
             searchMessage.append(post.getComments().get(j).getMessage()
                        + ", ");
             searchMessage.append(post.getComments().get(j).getCreatedTime()
                        + ", ");
             searchMessage.append(post.getComments().get(j).getLikeCount()
                        + "\n");

                         userId=post.getComments().get(j).getFrom().getId();
             User user = facebook.getUser(userId);
             System.out.println(user);
            }
        }

        searchResult = searchResult + searchMessage.toString();
        System.out.println(searchMessage.toString());
        return searchResult;
    }
	
	public static void getUsername() {

		URL url;

		try {
			// get URL content
			url = new URL("https://www.facebook.com/1491402641189118");
			URLConnection conn = url.openConnection();

			// open the stream and put it into BufferedReader
			BufferedReader br = new BufferedReader(
                               new InputStreamReader(conn.getInputStream()));

			String inputLine;

			//save to this filename
			String fileName = "test.txt";
			File file = new File(fileName);

			if (!file.exists()) {
				file.createNewFile();
			}

			//use FileWriter to write file
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			while ((inputLine = br.readLine()) != null) {
				bw.write(inputLine);
			}

			bw.close();
			br.close();

			System.out.println("Done");

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public static void main(String[] args) throws IOException, FacebookException, InterruptedException, JSONException {
		// TODO Auto-generated method stub
		String appId = "1604980453116311 : autobotsam" ;
		String appSecret = "1a802d7abbf1cfb769b7dec010d40c27";
		String commaSeparetedPermissions = "user_birthday, user_religion_politics, user_relationships, user_relationship_details, user_hometown, user_location, user_likes, user_education_history, user_work_history, user_website, user_managed_groups, user_events, user_photos, user_videos, user_friends, user_about_me, user_status, user_games_activity, user_tagged_places, user_posts, read_page_mailboxes, rsvp_event, email, ads_management, ads_read, read_insights, manage_pages, publish_pages, publish_actions, read_custom_friendlists, user_actions.books, user_actions.music, user_actions.video, user_actions.news, user_actions.fitness, public_profile, read_stream";
		String accessToken = "CAAWzuKHHiZAcBAJyJjZBaa85FpoMqqVb1FZCOMdLtZCi6GZCKoa4Lk6iPmuk7T0MA1FIQVWsOAZBLbCu61vJrU493XUFrXZC4Tj8SfL7oKFZCNWpc5RILfFKAOgvW2UVwEZAKYuuoTPxky9V5b3g1qRNl0aZBZAJ0ZBBCTOYIfak9p2AW2vo1cukGtxBOBkAILHEPALpqiZCEE9RDogZDZD";
		File file  = new File("fuid.txt");
		Facebook facebook = new FacebookFactory().getInstance();
		facebook.setOAuthAppId(appId, appSecret);
		facebook.setOAuthPermissions(commaSeparetedPermissions);
		facebook.setOAuthAccessToken(new AccessToken(accessToken));
		
		//Action list call
			
			//searchUser(facebook);
			//getInfor(facebook,file);
			//System.out.println(getFacebookPostes(facebook,"109076526103269"));
			getUsername();
			
			
	
		
	}
}
