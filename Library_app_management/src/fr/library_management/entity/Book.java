package fr.library_management.entity;

public class Book {
	private int id_book;
	private String title;
	private String author;
	private String publisher;
	private String category;
	private int page_count;
	private String language;
	private String description;
	private String image;
	private String format;
	private double price;
	private int download_count;
	
	
	public Book() {
	}

	
	

	public Book(String title, String author, double price) {
		if (price < 0) {
			throw new IllegalArgumentException("Price cannot be negative.");
		}
		this.title = title;
		this.author = author;
		this.price = price;
	}




	public Book(String title, String author, String publisher, String category, int page_count,
			String language, String description, String image, String format, double price, int download_count) {
		if (price < 0) {
			throw new IllegalArgumentException("Price cannot be negative.");
		}
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.category = category;
		this.page_count = page_count;
		this.language = language;
		this.description = description;
		this.image = image;
		this.format = format;
		this.price = price;
		this.download_count = download_count;
	}




	public int getId_book() {
		return id_book;
	}




	public void setId_book(int id_book) {
		this.id_book = id_book;
	}




	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public String getAuthor() {
		return author;
	}




	public void setAuthor(String author) {
		this.author = author;
	}




	public String getPublisher() {
		return publisher;
	}




	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}




	public String getCategory() {
		return category;
	}




	public void setCategory(String category) {
		this.category = category;
	}




	public int getPage_count() {
		return page_count;
	}




	public void setPage_count(int page_count) {
		this.page_count = page_count;
	}




	public String getLanguage() {
		return language;
	}




	public void setLanguage(String language) {
		this.language = language;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public String getImage() {
		return image;
	}




	public void setImage(String image) {
		this.image = image;
	}




	public String getFormat() {
		return format;
	}




	public void setFormat(String format) {
		this.format = format;
	}




	public double getPrice() {
		return price;
	}




	public void setPrice(double price) {
		if (price < 0) {
			throw new IllegalArgumentException("Price cannot be negative.");
		}
		this.price = price;
	}




	public int getDownload_count() {
		return download_count;
	}




	public void setDownload_count(int download_count) {
		this.download_count = download_count;
	}
	
	
	
	
	
}
