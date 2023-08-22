package miukkik.freezepanes;

import org.apache.wicket.Request;
import org.apache.wicket.Response;
import org.apache.wicket.Session;
/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see miukkik.freezepanes.StartFreezePanes#main(String[])
 */
public class WicketApplication extends org.apache.wicket.protocol.http.WebApplication {   

	
	/**
	 * Constructor
	 */
	public WicketApplication() {
		
	}

	@Override
	 public Session newSession(Request request, Response response) {
	 return new FpSession(request);
	 }

	
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	public Class<HomePage> getHomePage()
	{
		return HomePage.class;
	}

}
