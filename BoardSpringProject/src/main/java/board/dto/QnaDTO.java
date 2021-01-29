package board.dto;

import org.apache.ibatis.type.Alias;

@Alias("qna")
public class QnaDTO {
	private int qno; 
	private String title;
	private String content;
	private String date;
	private String writer;
	private int status;
	private String response;
	
	public QnaDTO(int qno, String title, String content, String date, String writer, int status, String response) {
		super();
		this.qno = qno;
		this.title = title;
		this.content = content;
		this.date = date;
		this.writer = writer;
		this.status = status;
		this.response = response;
	}

	public QnaDTO(String title, String content, String writer) {
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

	public int getQno() {
		return qno;
	}

	public void setQno(int qno) {
		this.qno = qno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "QnaDTO [qno=" + qno + ", title=" + title + ", content=" + content + ", date=" + date + ", writer="
				+ writer + ", status=" + status + ", response=" + response + "]";
	}
	
	
}
