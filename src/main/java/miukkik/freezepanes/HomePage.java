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

	private static int FREEZE_ROWS = 2;

	// TODO Add any page properties or variables here

	/**
	 * Constructor that is invoked when page is invoked without a session.
	 * 
	 * @param parameters
	 *            Page parameters
	 */
	public HomePage(final PageParameters parameters) {

		Table table = new Table();

		// Test inputs
		table.addRow("", "", "", "", "", "", "", "", "vko41\nyht.", "Suun.", "Ero", "Jakso");
		table.addRow("", "(41) 10.10.", "ti 11.10.", "ke 12.10.", "to 13.10.", "pe 14.10.", "la 15.10.", "su 16.10.", "", "", "", "");
		table.addRow("Annamaija", "", "3-15, Asiakas Oy/ Paketointi", "", "3-15, Asiakas Oy/ Paketointi", "3-15, Asiakas Oy/ Paketointi", "3-15, Asiakas Oy/ Paketointi", "3-15, Asiakas Oy/ Paketointi", "36", "60", "-24", "36");
		table.addRow("Jaska", "", "", "", "", "", "", "", "", "", "0", "");
		table.addRow("Jorma", "", "", "", "", "", "", "", "", "", "0", "");
		table.addRow("Jorma", "6:30- 19 vapaa selite tähän menee laskulle, Asiakas Oy/ Kuljetus", "", "8-16, Asiakas Oy/ Toimitus 16- 21.15, Asiakas Oy/ Paketointi", "", "", "", "", "25,75", "8", "17,75", "25,75");
		table.addRow("Kari 401731", "9-10, Asiakas Oy/ Kuljetus", "", "9-10, Asiakas Oy/ Kuljetus", "", "9-10, Asiakas Oy/ Kuljetus", "", "9-10, Asiakas Oy/ Kuljetus", "4", "4", "0", "4");
		table.addRow("Liisa", "", "", "", "", "Sairausloma, 7- 19", "", "", "", "", "0", "");
		table.addRow("Martti", "", "", "", "", "", "", "", "", "", "0", "");
		table.addRow("Matti", "", "", "", "", "", "", "", "", "", "0", "");
		table.addRow("Matti", "8-18 muutin aikaa, Asiakas Oy/ Paketointi 18- 18,30, Asiakas Oy/ Toimitus", "8-16, Asiakas Oy/ Paketointi", "8-16, Asiakas Oy/ Paketointi", "8-16, Asiakas Oy/ Paketointi", "8-16, Asiakas Oy/ Paketointi", "", "", "42,5", "42", "0,5", "42,5");
		table.addRow("Mauri", "", "", "", "", "", "", "", "", "", "0", "");
		table.addRow("Testikalle", "", "", "", "", "", "", "", "", "", "0", "");
		table.addRow("Tuntinetin", "", "", "", "", "", "", "", "", "", "0", "");
		table.addRow("(nimettömät", "", "3-15, Asiakas Oy/ Paketointi", "8-12, Asiakas Oy/ Paketointi", "3-15, Asiakas Oy/ Paketointi", "", "3-15, Asiakas Oy/ Paketointi", "", "", "40", "−40", "");	
		// end test inputs

		RepeatingView headerContainer = new RepeatingView("tablehead");
		add(headerContainer);
		for (int i=0; i<FREEZE_ROWS; i++) {
			WebMarkupContainer container = new WebMarkupContainer(String.valueOf(i));
			headerContainer.add(container);
			RepeatingView header = new RepeatingView("topheader");
			container.add(header);
			for (int j=0; j<table.getTable().get(i).size(); j++) {
				header.add(new Label(String.valueOf(j), table.getTable().get(i).get(j).getContent()));
			}

		}    	
		RepeatingView repeatContainer = new RepeatingView("tablebody");
		add(repeatContainer);
		for (int i=FREEZE_ROWS; i<table.getTable().size(); i++) {
			WebMarkupContainer container = new WebMarkupContainer(String.valueOf(i));

			repeatContainer.add(container);
			container.add(new Label("leftheader", table.getTable().get(i).get(0).getContent()));

			RepeatingView cell = new RepeatingView("cell");
			container.add(cell);
			for (int j=1; j<table.getTable().get(i).size(); j++) {
				cell.add(new Label(String.valueOf(j), table.getTable().get(i).get(j).getContent()));
			}

		}

	}
}
