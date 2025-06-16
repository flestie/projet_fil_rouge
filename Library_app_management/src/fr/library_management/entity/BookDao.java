package fr.library_management.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookDao {
	
	private Connection cn = null;
	
	private String sql = "";
	
	PreparedStatement ps = null;
	
	ResultSet rs = null;
	
	public BookDao() {
		cn = new ConnectorMysql().getCn();
	}
	
	public void addBook(Book b) {
		
		// Step 1: Check if the book already exists in the library
	    if (inTheLibrary(b)) {
	        System.out.println("You already have this book in your library.");
	        
	        // Step 2: Fetch and assign the existing ID to the Book object
	        String query = "SELECT id_book FROM book WHERE title = ? AND author = ? AND language = ? AND publisher = ?";
	        try {
	            ps = cn.prepareStatement(query);
	            ps.setString(1, b.getTitle());
	            ps.setString(2, b.getAuthor());
	            ps.setString(3, b.getLanguage());
	            ps.setString(4, b.getPublisher());

	            rs = ps.executeQuery();
	            if (rs.next()) {
	                int existingId = rs.getInt("id_book");
	                b.setId_book(existingId);
	                System.out.println("Existing book ID: " + existingId);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return;
	    }
		
		
		
		
		String sql = "INSERT INTO book (title, author, publisher, category,"
				+ " page_count, language, description, image, format, price, "
				+ "download_count) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, b.getTitle());
			ps.setString(2, b.getAuthor());
			ps.setString(3, b.getPublisher());
			ps.setString(4, b.getCategory());
			ps.setInt(5, b.getPage_count());
			ps.setString(6, b.getLanguage());
			ps.setString(7, b.getDescription());
			ps.setString(8, b.getImage());
			ps.setString(9, b.getFormat());
			ps.setDouble(10, b.getPrice());
			ps.setDouble(11, b.getDownload_count());
			int rowsAffected = ps.executeUpdate();
			System.out.println(rowsAffected);
			if(rowsAffected >0) {
				rs = ps.getGeneratedKeys();
				if (rs.next()) {
					int generatedId = rs.getInt(1);
					b.setId_book(generatedId);
					System.out.println("Book added with ID: " + generatedId);
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public boolean inTheLibrary(Book b) {
		String sql = "Select * from book";
		
		try {
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getString("title").equals(b.getTitle()) && rs.getString("author").equals(b.getAuthor())
						&& rs.getString("language").equals(b.getLanguage()) && rs.getString("publisher").equals(b.getPublisher())) {
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	public void removeBook(Book b) {
		String sql = "DELETE from book where id_book = ?";
		
		try {
			ps = cn.prepareStatement(sql);
			ps.setInt(1, b.getId_book());
			int rowsAffected = ps.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("The product with id: " + b.getId_book() + " has been removed.");
			}else {
				System.out.println("No product found with ID: " + b.getId_book());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int countAllBooks() {
		String sql = "Select * from book;";
		int i = 0;
		try {
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;

	}

	public void showAllBooks() {
		String sql = "Select * from book;";

		try {
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				int idBook = rs.getInt("id_book");
				String title = rs.getString("title");
				double price = rs.getDouble("price");

				System.out.println("ID: " + idBook + ". Libelle: " + title + ". Prix: " + price);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updatePriceBook(Book b) {
		String sql = "UPDATE book SET price = ? WHERE id_book = ?;";

		try {
			ps = cn.prepareStatement(sql);
			ps.setDouble(1, b.getPrice());
			ps.setInt(2, b.getId_book());
			ps.executeUpdate();
			System.out.println("The price of " + b.getTitle() + " has updated to " + b.getPrice());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updatePriceBook(int id, double price) {
		
		if(price<0) {
			System.out.println("Price cannot be negative.");
			return;
		}
		
		String sql = "UPDATE book SET price = ? WHERE id_book = ?;";

		try {
			ps = cn.prepareStatement(sql);
			ps.setDouble(1, price);
			ps.setInt(2, id);
			ps.executeUpdate();
			System.out.println("The price of book id: " + id + " has updated to " + price);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void updateImageBook(int id, String img) {
		String sql = "UPDATE book SET image = ? WHERE id_book = ?";
		
		try {
			ps = cn.prepareStatement(sql);
			ps.setString(1, img);
			ps.setInt(2, id);
			ps.executeUpdate();
			System.out.println("The image of the book id: " + id + " has succesfully changed to '" + img + "'.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
