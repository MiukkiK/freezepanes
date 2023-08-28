package miukkik.freezepanes;

/**
 * A single cell component of a table.
 * 
 * @author Mia Kallio
 */
public class Cell implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private String content;
	private String referenceId;
	
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

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
	
	
}
