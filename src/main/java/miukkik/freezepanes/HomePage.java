package miukkik.freezepanes;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;


/**
 * Main page of the application.
 * @author Mia Kallio
 */
public class HomePage extends FpPage {

	private static final long serialVersionUID = 1L;

	private final int FREEZE_ROWS = 2;

	private Label focusTarget;

	public HomePage() {
		Table table = getFpSession().getTable();

		final TextField<String> editBox = new TextField<String>("editbox");
		final Form<String> editForm = new Form<String>("editform");
		
		
		// Edit area of the table, hidden at start, becomes visible when a Cell is selected.
		
		editForm.setVisible(false);
		add(editForm);
		editForm.setOutputMarkupPlaceholderTag(true);
		editForm.add(editBox);
		editBox.setOutputMarkupPlaceholderTag(true);
		editForm.add(new AjaxButton("savebutton") {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				if (target != null) {
					editForm.setVisible(false);
					target.addComponent(editForm);
					target.addComponent(focusTarget);
				}
			}
		});
		
		editForm.add(new AjaxLink<String>("cancelbutton") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				if (target != null) {
					editForm.setVisible(false);
					target.addComponent(editForm);
				}
			}
		});
		
		// Top header of the Table, height defined in FREEZE_ROWS.
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
		// Rest of the table, first Cell of each row is part of the left header.
		RepeatingView repeatContainer = new RepeatingView("tablebody");
		add(repeatContainer);
		for (int i=FREEZE_ROWS; i<table.getTable().size(); i++) {
			WebMarkupContainer container = new WebMarkupContainer(String.valueOf(i));

			repeatContainer.add(container);
			container.add(new Label("leftheader", table.getTable().get(i).get(0).getContent()));

			RepeatingView cells = new RepeatingView("cell");
			container.add(cells);
			for (int j=1; j<table.getTable().get(i).size(); j++) {
				final PropertyModel<String> model = new PropertyModel<String>(table.getTable().get(i).get(j), "content");
				final Label label = new Label("celldata", model);			
				label.setOutputMarkupId(true);
				AjaxLink<Cell> link = new AjaxLink<Cell>(String.valueOf(j)) {
					private static final long serialVersionUID = 1L;

					//Actions when a cell is clicked
					@Override
					public void onClick(AjaxRequestTarget target) {						
						if ((focusTarget == null)||(!label.getMarkupId().equals(focusTarget.getMarkupId()))) {
							focusTarget = label;
							editForm.setVisible(true);
							editBox.setModel(model);
							target.addComponent(editForm);
							target.addComponent(editBox);
							
						}
						target.focusComponent(editBox);
					}
				};
				cells.add(link);
				link.add(label);
			}
		}
	}
}
