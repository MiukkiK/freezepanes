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
		final AjaxLink<String> randomEdit = new AjaxLink<String>("randomedit") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				if (target != null) {}
			// Random randoms = new Random();
			// int rndI = FREEZE_ROWS + randoms.nextInt(table.getHeight() - FREEZE_ROWS);
			// int rndJ = 1 + randoms.nextInt(table.getWidth() - 1);
			// TODO set the randomized cell label to focusTarget variable
			}
			
		};
		
		// Edit area of the table, hidden at start, becomes visible when a Cell is selected.
		
		add(randomEdit);
		randomEdit.setOutputMarkupPlaceholderTag(true);
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
					randomEdit.setVisible(true);
					target.addComponent(editForm);
					target.addComponent(randomEdit);
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
					randomEdit.setVisible(true);
					target.addComponent(editForm);
					target.addComponent(randomEdit);
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
			for (int j=0; j<table.getWidth(); j++) {
				headers.add(new Label(String.valueOf(j), table.get(i,j).getContent()));
			}

		} 
		// Rest of the table, first Cell of each row is part of the left header.
		RepeatingView repeatContainer = new RepeatingView("tablebody");
		add(repeatContainer);
		for (int i=FREEZE_ROWS; i<table.getHeight(); i++) {
			WebMarkupContainer container = new WebMarkupContainer(String.valueOf(i));

			repeatContainer.add(container);
			container.add(new Label("leftheader", table.get(i,0).getContent()));

			RepeatingView cells = new RepeatingView("cell");
			container.add(cells);
			for (int j=1; j<table.getWidth(); j++) {
				final PropertyModel<String> model = new PropertyModel<String>(table.get(i,j), "content");
				final Label label = new Label("celldata", model);			
				label.setOutputMarkupId(true);
				table.get(i, j).setReferenceId(label.getMarkupId());
				AjaxLink<Cell> link = new AjaxLink<Cell>(String.valueOf(j)) {
					private static final long serialVersionUID = 1L;

					//Actions when a cell is clicked
					@Override
					public void onClick(AjaxRequestTarget target) {						
						if ((focusTarget == null)||(!label.getMarkupId().equals(focusTarget.getMarkupId()))) {
							focusTarget = label;
							editForm.setVisible(true);
							randomEdit.setVisible(false);
							editBox.setModel(model);
							target.addComponent(randomEdit);
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
