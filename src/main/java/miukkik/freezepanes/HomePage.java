package miukkik.freezepanes;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.RepeatingView;

/**
 * Homepage
 */
public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;

	// TODO Add any page properties or variables here

    /**
	 * Constructor that is invoked when page is invoked without a session.
	 * 
	 * @param parameters
	 *            Page parameters
	 */
    public HomePage(final PageParameters parameters) {
 
    	Table table = new Table();
    	// Test fill
    	table.addRow("Steve", "Hank");
    	table.addRow("Carl", "Ellie", "Joe");

    	RepeatingView repeatContainer = new RepeatingView("tablerow");
		add(repeatContainer);
    	for (int i=0; i<table.getTable().size(); i++) {
    		WebMarkupContainer container = new WebMarkupContainer(String.valueOf(i));
    		repeatContainer.add(container);
    		RepeatingView cell = new RepeatingView("repeatingcell");
    		container.add(cell);
    		for (int j=0; j<table.getTable().get(i).size(); j++) {
    			cell.add(new Label(String.valueOf(j), table.getTable().get(i).get(j).getContent()));
    		}
    		
    	}
    	
    }
}
