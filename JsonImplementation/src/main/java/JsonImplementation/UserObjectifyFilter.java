package JsonImplementation;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import com.googlecode.objectify.ObjectifyFilter;
import com.googlecode.objectify.ObjectifyService;
import com.json.bean.User;

import JsonImplementation.UserImpl;

/**
 * Servlet Filter implementation class Sample4
 */

@javax.servlet.annotation.WebFilter(urlPatterns = {"/*"})
public class UserObjectifyFilter extends ObjectifyFilter {

		
		
	
}
