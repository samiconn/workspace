/**
 * 
 */
package fb4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import facebook4j.*;
import facebook4j.User.AgeRange;
import facebook4j.api.SearchMethods;
import facebook4j.auth.AccessToken;
import facebook4j.internal.org.json.JSONObject;
/**
 * @author samiconn
 *
 */
public class fb4jConnect {
	
	public static String appId = "1500845136892955" ;
	public static String appSecret = "1a802d7abbf1cfb769b7dec010d40c27";
	public static String commaSeparetedPermissions = "user_birthday, user_religion_politics, user_relationships, user_relationship_details, user_hometown, user_location, user_likes, user_education_history, user_work_history, user_website, user_managed_groups, user_events, user_photos, user_videos, user_friends, user_about_me, user_status, user_games_activity, user_tagged_places, user_posts, read_page_mailboxes, rsvp_event, email, ads_management, ads_read, read_insights, manage_pages, publish_pages, publish_actions, read_custom_friendlists, user_actions.books, user_actions.music, user_actions.video, user_actions.news, user_actions.fitness, public_profile, read_stream";
	public static String accessToken = "CAAWzuKHHiZAcBAKfp5c1ZAcTlZBgC2rMyHkanLv6jVocZBNaHIm0pVgB7xuHREYofoKcnz18Hz7aIVejQLoQNEyleaANZAyZBypEMk2rqVKoRAZBZAbmZBGnp8VczOvXSqYOoKo5rkrEwkZAYHxtNXm8sQLfCczC4CHE8o2HesrXbzW3mumATlw7hZC";
	
	/**
	 * @param args
	 * @throws FacebookException 
	 */
	// posting to facebook
	public static void post(Facebook facebook) throws FacebookException {
		
		PostUpdate post;
		try {
			post = new PostUpdate(new URL("http://facebook4j.org"))
			        .picture(new URL("http://facebook4j.org/images/hero.png"))
			        .name("Facebook4J - A Java library for the Facebook Graph API")
			        .caption("facebook4j.org")
			        .description("Facebook4J is a Java library for the Facebook Graph API.");
			facebook.postFeed(post);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//getting newsfeed
	public static void newsFeed(Facebook facebook) throws FacebookException {
		
		ResponseList<Post> feed = facebook.getFeed();
		
		for (int i = 0; i < feed.size(); i++) {
			
			Post ps = feed.get(i);
			String message = ps.getMessage();
			System.out.println(message);
		}
			
	}
	
	//searching user
	public static void searchUser(Facebook facebook) throws FacebookException {
		
		ResponseList<User> results = facebook.searchUsers(" ");
				
		for (int i = 0; i < results.size(); i++) {
			
			User us = results.get(i);
			String id = us.getId();
			String username = us.getName();
			String birthday = us.getBirthday();
			IdNameEntity loca = us.getLocation();
			
			
			System.out.println(i+". "+ id +" "+" "+username+" "+ birthday);
			if (loca != null)
				System.out.println(loca.getName());
			
			
			
			
			
		}
			
	}
	
	//searching posts
	public static void searchPost(Facebook facebook) throws FacebookException {
		
		ResponseList<Post> posts = facebook.searchPosts("girl");
		
		for (int i = 0; i < posts.size(); i++) {
			
			Post ps = posts.get(i);
			String st = ps.getId();
			System.out.println(st);
		}
	}
	
	public static void searchGroup(Facebook facebook) throws FacebookException {
		
		ResponseList<Group> group = facebook.searchGroups("sexy");
		
		for (int i = 0; i < group.size(); i++) {
			
			Group gr = group.get(i);
			String id = gr.getId();
			String name = gr.getName();
			String desr = gr.getDescription();
			String email = gr.getEmail();
			
			System.out.println(i+"."+id+" "+name+" "+ desr +" "+ email);
		}
	}
	
	public static void getFriendlist(Facebook facebook) throws FacebookException { 
		
		ResponseList<Friendlist> frlist = facebook.getFriendlists();
		for (int j = 0; j < frlist.size(); j++) {
			Friendlist fr = frlist.get(j);
			String frId = fr.getId();
			System.out.println(frId);
		}
	}
	
	//Group...
	public static void groupMem(Facebook facebook) throws FacebookException {
	
		String groupId = "469294856435522";
		ResponseList<GroupMember> grme = facebook.getGroupMembers(groupId);
		for (Iterator<GroupMember> gr = grme.iterator(); gr.hasNext();){
			User mem = gr.next();
			String memId = mem.getId();
			
			System.out.println(memId);
		}
	}
	//void main
	public static void readFile(Facebook facebook, File sample) throws FileNotFoundException, FacebookException {
		
		
		BufferedReader reader = new BufferedReader(new FileReader(sample));
		while (true) {
			
			try {
				String line = reader.readLine();
				
			if (line == null)
			{
				break;
			}
			ResponseList<User> results = facebook.searchUsers(line);
			
			for (int i = 0; i < results.size(); i++) {
				
				User us = results.get(i);
				String id = us.getId();
				String username = us.getName();
				String birthday = us.getBirthday();
				IdNameEntity loca = us.getLocation();
							
				System.out.println(i+". "+ id +" "+" "+username+" "+ birthday);
				if (loca != null)
					System.out.println(loca.getName());
			}
			} catch(IOException e) {
				System.out.println(e);
			}
		}
		
		
	}
	public static void main(String[] args) throws FacebookException, FileNotFoundException {
		// TODO Auto-generated method stub
		Facebook facebook = new FacebookFactory().getInstance();
		facebook.setOAuthAppId(appId, appSecret);
		facebook.setOAuthPermissions(commaSeparetedPermissions);
		facebook.setOAuthAccessToken(new AccessToken(accessToken));
		File file =  new File("sample.txt");
		//List of actions
		
		newsFeed(facebook);
		//searchUser(facebook);
		//searchPost(facebook);
		//searchGroup(facebook);
		//getFriendlist(facebook);
		//groupMem(facebook);
		readFile(facebook,file);
	}

}
