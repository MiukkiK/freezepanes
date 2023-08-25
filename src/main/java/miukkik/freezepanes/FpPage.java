package miukkik.freezepanes;

/**
 * Custom WebPage extension that passes Table element along from Session.
 * @author Mia Kallio
 */
public abstract class FpPage extends org.apache.wicket.markup.html.WebPage {
	
	public FpSession getFpSession() {
		return (FpSession) getSession();
	} 
	public Table getTable() {
		return getFpSession().getTable();
	}
}
