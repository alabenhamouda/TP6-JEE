package metier;

import java.util.*;
import java.sql.*;
import dao.ArticleDAO;

public class Article {
	private String code;
	private String nom;
	private String description;
	private int quantite;
	private double prix;

	public static ArrayList<Article> rechercheArticles(String code, String nom) {
		ArrayList<Article> res = new ArrayList<>();
		try {
			ArticleDAO art = ArticleDAO.getInstance();
			ResultSet rs = art.rechercheArticle(code, nom);
			while (rs.next()) {
				Article item = new Article();
				item.setCode(rs.getString("code"));
				item.setDescription(rs.getString("description"));
				item.setNom(rs.getString("nom"));
				item.setPrix(rs.getDouble("prix"));
				item.setQuantite(rs.getInt("quantite"));
				res.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
}
