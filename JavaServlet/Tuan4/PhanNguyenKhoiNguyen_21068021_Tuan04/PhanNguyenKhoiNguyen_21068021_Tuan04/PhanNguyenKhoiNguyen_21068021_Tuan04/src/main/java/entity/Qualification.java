package entity;

public class Qualification {
	private String classs;
	private String board;
	private String percentage;
	private String yearOfPassing;
	
	
	public String getClasss() {
		return classs;
	}
	public void setClasss(String classs) {
		this.classs = classs;
	}
	public String getBoard() {
		return board;
	}
	public void setBoard(String board) {
		this.board = board;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public String getYearOfPassing() {
		return yearOfPassing;
	}
	public void setYearOfPassing(String yearOfPassing) {
		this.yearOfPassing = yearOfPassing;
	}
	public Qualification(String classs, String board, String percentage, String yearOfPassing) {
		this.classs = classs;
		this.board = board;
		this.percentage = percentage;
		this.yearOfPassing = yearOfPassing;
	}
	public Qualification() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Qualification [classs=" + classs + ", board=" + board + ", percentage=" + percentage
				+ ", yearOfPassing=" + yearOfPassing + "]";
	}
	
	
	
	
	

}