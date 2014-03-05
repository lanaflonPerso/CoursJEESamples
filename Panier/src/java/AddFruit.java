import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modele.Panier;

public class AddFruit extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String fruit = request.getParameter("fruit");
		if( fruit != null && !fruit.equals("") ) // Si j'ai appelé ma Servlet avec un nom de fruit.
		{
			HttpSession session = request.getSession();
			Panier panier = (Panier)session.getAttribute("monPanier"); // Je récupère le bean panier stocké dans ma session
			if(panier == null) // Si notre panier est vide
			{
				panier = new Panier(); // Je le crée
			}
			HashMap<String,Integer> fruits = panier.getFruits();
			if(fruits == null) fruits = new HashMap<String,Integer>();
			Integer nbFruit = fruits.get(fruit);
			if(fruits.get(fruit) == null) nbFruit = 0;
			fruits.put(fruit, nbFruit+1);
			panier.setFruits(fruits);
			session.setAttribute("monPanier", panier);
		}
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}
}