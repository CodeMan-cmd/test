package pojo;

import java.sql.Date;

public class Books {
	private int bookId;				//ͼ����
	private String bookName;		//����
	private String bookAuthor;		//����
	private String bookPublish;		//������
	private int bookPage;			//ҳ��
	private double bookPrice;		//�۸�'
	private Date createDate;		//���ʱ��
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookPublish() {
		return bookPublish;
	}
	public void setBookPublish(String bookPublish) {
		this.bookPublish = bookPublish;
	}
	public int getBookPage() {
		return bookPage;
	}
	public void setBookPage(int bookPage) {
		this.bookPage = bookPage;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	@Override
	public String toString() {
		return "Books [bookId=" + bookId + ", bookName=" + bookName
				+ ", bookAuthor=" + bookAuthor + ", bookPublish=" + bookPublish
				+ ", bookPage=" + bookPage + ", bookPrice=" + bookPrice
				+ ", createDate=" + createDate + "]";
	}
	
	public Books( String bookName, String bookAuthor,
			String bookPublish, int bookPage, double bookPrice, Date createDate) {
		super();
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPublish = bookPublish;
		this.bookPage = bookPage;
		this.bookPrice = bookPrice;
		this.createDate = createDate;
	}
	public Books() {
		super();
	}
	
}
