package miukkik.freezepanes;

import org.apache.wicket.markup.html.basic.Label;

/**
 * A single cell component of a table.
 * 
 * @author Mia Kallio
 */
public class Cell implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private String content;
	private Label label;
	
	public Cell() {
		content = "";
	}
	
	public Cell(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

}
