package board.dto;

import java.io.File;

//파일 정보를 저장
public class FileDTO {
	private int bno;
	private String fileName;
	private String writer;
	private String type;

	public FileDTO(File file,String writer) {
		super();
		this.fileName = file.getName();
		this.writer = writer;
		bno = 0;
		//error.png 
		switch(fileName.substring(fileName.lastIndexOf(".")+1)) {
		case "png":
		case "bmp":
		case "jpg":
		case "gif":
			type="image";
			break;
		default:
			type="normal";
		}
	}
	
	public FileDTO(int bno, String writer, String fileName) {
		super();
		this.bno = bno;
		this.writer = writer;
		this.fileName = fileName;
		switch(fileName.substring(fileName.lastIndexOf(".")+1)) {
		case "png":
		case "bmp":
		case "jpg":
		case "gif":
			type="image";
			break;
		default:
			type="normal";
		}
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	
	
}
