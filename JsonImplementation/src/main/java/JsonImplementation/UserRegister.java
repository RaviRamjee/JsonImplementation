package JsonImplementation;

import javax.servlet.annotation.WebListener;

import com.google.cloud.datastore.DatastoreOptions;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;
import com.json.bean.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@WebListener
public class UserRegister implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		/**ObjectifyFactory oFactory = ObjectifyService.factory();
        oFactory.register(User.class);*/
		
		//ObjectifyService.init();
		ObjectifyService.init(new ObjectifyFactory(
			    DatastoreOptions.newBuilder()
			        .setProjectId("PROJECT_ID")
			        .build()
			        .getService()
			    ));
		ObjectifyService.register(User.class);
		//ObjectifyService.begin();
		
		
		
		//ServletContext sc=sce.getServletContext();
		//sc.setAttribute("reg", "regUser");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}
}
