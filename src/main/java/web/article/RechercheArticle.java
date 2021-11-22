package web.article;

import java.io.IOException;
import metier.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RechercheArticle
 */
@WebServlet("/RechercheArticle")
public class RechercheArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechercheArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String code = request.getParameter("code");
		String name = request.getParameter("nom");
		request.setAttribute("code", code);
		request.setAttribute("name", name);
		ArrayList<Article> list = Article.rechercheArticles(code, name);
		if(list.isEmpty()) {
			request.getRequestDispatcher("ArticleInexistant.jsp").forward(request, response);
		} else {
			request.setAttribute("products", list);
			Cookie cookie = new Cookie ("cookie", "larticlerechercheexiste");
			response.addCookie(cookie);
			request.getRequestDispatcher("ArticleTrouve.jsp").forward(request, response);
		}
	}

}
