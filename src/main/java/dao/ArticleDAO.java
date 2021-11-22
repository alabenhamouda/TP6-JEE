package dao;
import java.sql.*;
import javax.sql.*;

public class ArticleDAO {
	
	static private ArticleDAO instance = null;
	private ArticleDAO() {
		
	}
	public static ArticleDAO getInstance() {
		if(instance == null)
			instance = new ArticleDAO();
		return instance;
	}
	
	public ResultSet rechercheArticle(String code, String nom) throws ClassNotFoundException, SQLException {
		Connection conn = SQLConnection.getConnection();
		PreparedStatement ps;
		if(!code.isEmpty()) {
			ps = conn.prepareStatement("SELECT * FROM products WHERE UPPER(CODE) = UPPER(?) AND UPPER(nom) LIKE UPPER(?)");
			ps.setString(1, code);
			ps.setString(2, "%" + nom + "%");
		} else {
			ps = conn.prepareStatement("SELECT * FROM products WHERE UPPER(nom) LIKE UPPER(?)");
			ps.setString(1, "%" + nom + "%");
		}
		return ps.executeQuery();
	}

}
