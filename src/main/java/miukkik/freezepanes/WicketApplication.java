package miukkik.freezepanes;

import org.apache.wicket.protocol.http.WebApplication;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see miukkik.freezepanes.StartFreezePanes#main(String[])
 */
public class WicketApplication extends WebApplication {   
	public static Table TABLE = new Table();
	
	/**
	 * Constructor
	 */
	public WicketApplication() {
		// Test inputs
		TABLE.addRow("", "", "", "", "", "", "", "", "vko41\nyht.", "Suun.", "Ero", "Jakso");
		TABLE.addRow("", "(41) 10.10.", "ti 11.10.", "ke 12.10.", "to 13.10.", "pe 14.10.", "la 15.10.", "su 16.10.", "", "", "", "");
		TABLE.addRow("Annamaija", "", "3-15, Asiakas Oy/ Paketointi", "", "3-15, Asiakas Oy/ Paketointi", "3-15, Asiakas Oy/ Paketointi", "3-15, Asiakas Oy/ Paketointi", "3-15, Asiakas Oy/ Paketointi", "36", "60", "-24", "36");
		TABLE.addRow("Jaska", "", "", "", "", "", "", "", "", "", "0", "");
		TABLE.addRow("Jorma", "", "", "", "", "", "", "", "", "", "0", "");
		TABLE.addRow("Jorma", "6:30- 19 vapaa selite tähän menee laskulle, Asiakas Oy/ Kuljetus", "", "8-16, Asiakas Oy/ Toimitus 16- 21.15, Asiakas Oy/ Paketointi", "", "", "", "", "25,75", "8", "17,75", "25,75");
		TABLE.addRow("Kari 401731", "9-10, Asiakas Oy/ Kuljetus", "", "9-10, Asiakas Oy/ Kuljetus", "", "9-10, Asiakas Oy/ Kuljetus", "", "9-10, Asiakas Oy/ Kuljetus", "4", "4", "0", "4");
		TABLE.addRow("Liisa", "", "", "", "", "Sairausloma, 7- 19", "", "", "", "", "0", "");
		TABLE.addRow("Martti", "", "", "", "", "", "", "", "", "", "0", "");
		TABLE.addRow("Matti", "", "", "", "", "", "", "", "", "", "0", "");
		TABLE.addRow("Matti", "8-18 muutin aikaa, Asiakas Oy/ Paketointi 18- 18,30, Asiakas Oy/ Toimitus", "8-16, Asiakas Oy/ Paketointi", "8-16, Asiakas Oy/ Paketointi", "8-16, Asiakas Oy/ Paketointi", "8-16, Asiakas Oy/ Paketointi", "", "", "42,5", "42", "0,5", "42,5");
		TABLE.addRow("Mauri", "", "", "", "", "", "", "", "", "", "0", "");
		TABLE.addRow("Testikalle", "", "", "", "", "", "", "", "", "", "0", "");
		TABLE.addRow("Tuntinetin", "", "", "", "", "", "", "", "", "", "0", "");
		TABLE.addRow("(nimettömät", "", "3-15, Asiakas Oy/ Paketointi", "8-12, Asiakas Oy/ Paketointi", "3-15, Asiakas Oy/ Paketointi", "", "3-15, Asiakas Oy/ Paketointi", "", "", "40", "−40", "");	
		// end test inputs
	}

	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	public Class<HomePage> getHomePage()
	{
		return HomePage.class;
	}

	public static Table getTable() {
		return TABLE;
	}
	
}
