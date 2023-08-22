package miukkik.freezepanes;

public abstract class FpPage extends org.apache.wicket.markup.html.WebPage {
	
	public FpSession getFpSession() {
		return (FpSession) getSession();
	} 
	public Table getTable() {
		return getFpSession().getTable();
	}
}
