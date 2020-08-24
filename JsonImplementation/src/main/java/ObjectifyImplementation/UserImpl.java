package ObjectifyImplementation;

import static com.googlecode.objectify.ObjectifyService.ofy;

import com.google.appengine.api.datastore.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.json.bean.User;

public class UserImpl {

	// saving user data
	public void save(User u) {
		ofy().save().entity(u).now();
	}
	public void save() {
        User u = new User();
		u.setUserId("one");
		u.setUserName("Ajay");
		u.setUserEmail("ajay@gmail.com");
		u.setUserAge(25);
		u.setUserAddress("Delhi");
		ofy().save().entity(u).now();
	}

	// extracting user data
	public void getUserData(User user) {
		User getUser = ofy().load().type(User.class).id(user.getUserId()).now();
		System.out.println(getUser.toString());
	}
	
	public void getUserByFilter(User u)
	{
		User filter = ofy().load().type(User.class).filter("userId =",u.getUserId()).first().now();
		System.out.println(filter);
	}

	// updating some data
	public void upadateUserData(User u) {
		u.setUserEmail("ajay@gmail.com");
		u.setUserAge(25);
		ofy().save().entity(u).now();
	}

	// deleting user data
	public void deleteUserdata(User u) {
		ofy().delete().entity(u).now();
	}

}
