package miukkik.freezepanes;

import org.apache.wicket.PageParameters;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.CompoundPropertyModel;


/**
 * Homepage
 */
public class HomePage extends FpPage {

	private static final long serialVersionUID = 1L;

	private final int FREEZE_ROWS = 2;

	/**
	 * Constructor that is invoked when page is invoked without a session.
	 * 
	 * @param parameters
	 *            Page parameters
	 */
	
	public HomePage(final PageParameters parameters) {
		Table table = getFpSession().getTable();

		RepeatingView headerContainer = new RepeatingView("tablehead");
		add(headerContainer);
		for (int i=0; i<FREEZE_ROWS; i++) {
			WebMarkupContainer container = new WebMarkupContainer(String.valueOf(i));
			headerContainer.add(container);
			RepeatingView headers = new RepeatingView("topheader");
			container.add(headers);
			for (int j=0; j<table.getTable().get(i).size(); j++) {
				headers.add(new Label(String.valueOf(j), table.getTable().get(i).get(j).getContent()));
			}

		}    	
		RepeatingView repeatContainer = new RepeatingView("tablebody");
		add(repeatContainer);
		for (int i=FREEZE_ROWS; i<table.getTable().size(); i++) {
			WebMarkupContainer container = new WebMarkupContainer(String.valueOf(i));

			repeatContainer.add(container);
			container.add(new Label("leftheader", table.getTable().get(i).get(0).getContent()));

			RepeatingView cells = new RepeatingView("cell");
			container.add(cells);
			for (int j=1; j<table.getTable().get(i).size(); j++) {
				Cell cell = table.getTable().get(i).get(j);
				CompoundPropertyModel<Cell> cellModel = new CompoundPropertyModel<Cell>(cell);
				AjaxLink<Cell> link = new AjaxLink<Cell>(String.valueOf(j), cellModel) {
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick(AjaxRequestTarget target) {
						getModelObject().setContent("");
						setResponsePage(HomePage.class);
					}

				};
				cells.add(link);
				Label label = new Label("celldata", cell.getContent());
				label.setOutputMarkupId(true);
				link.add(label);

			}

		}

	}
}
