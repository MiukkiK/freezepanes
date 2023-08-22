package miukkik.freezepanes;

public class Cell implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private String content;

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

}
