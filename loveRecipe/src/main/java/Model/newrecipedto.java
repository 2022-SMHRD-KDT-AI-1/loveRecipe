package Model;

public class newrecipedto {
	private int num;
	private String title;
	private String writer;
	private String filename;
	private String Content;
	public int getNum() {
		return num;
	}
	public newrecipedto(int num, String title, String writer, String filename, String content) {
		super();
		this.num = num;
		this.title = title;
		this.writer = writer;
		this.filename = filename;
		Content = content;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	
	
}
