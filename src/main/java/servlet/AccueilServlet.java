package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import bll.PersonneBLL;
import bo.Adresse;
import bo.Personne;

/**
 * Utilisation des toutes les operations de base du CRUD propose par JpaRepository
 */
@WebServlet("/accueil")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private PersonneBLL bll;
	
	@Override
	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Créer une liste de personnes
		Adresse adr1 = new Adresse("Nantes", "Rue du Calvaire");
		Adresse adr2 = new Adresse("Nantes", "Bd du Massacre");
		Adresse adr3 = new Adresse("Rennes", "Rue Charles de Gaules");
		Adresse adr4 = new Adresse("Lyon", "Rue Georges Pompidou");
		
		Personne pers1 = new Personne("CASSIN", "Etienne", adr1);
		Personne pers2 = new Personne("OGOU", "Brice", adr2);
		Personne pers3 = new Personne("HERVE", "Thomas", adr3);
		Personne pers4 = new Personne("GROUSSEAU", "Matthieu", adr4);		
		
		// 2. Insérer ces personnes en bdd
		bll.insert(pers1);
		bll.insert(pers2);
		bll.insert(pers3);
		bll.insert(pers4);
		
		// 3. Lister les personnes
		System.out.println("************************************");
		System.out.println("****AFFICHAGE DES PERSONNES ********");
		System.out.println("************************************");
		List<Personne> personnes = bll.selectAll();
		for (Personne current : personnes) {
			System.out.println(current);
		}
		
		// 4. Mettre à jour une personne
		System.out.println("************************************");
		System.out.println("**********MAJ DES PERSONNES ********");
		System.out.println("************************************");
		pers3.setPrenom("Clement");
		bll.update(pers3);
		
		// 5. Supprimer une personne
		System.out.println("************************************");
		System.out.println("****SUPPRESSION D'UNE PERSONNE *****");
		System.out.println("************************************");
		bll.delete(pers4);
		
		// 6. Lister les personnes
		System.out.println("************************************");
		System.out.println("****AFFICHAGE DES PERSONNES ********");
		System.out.println("************************************");
		personnes = bll.selectAll();
		for (Personne current : personnes) {
			System.out.println(current);
		}
		
		// 7. Consulter une personne
		System.out.println("************************************");
		System.out.println("****CONSULTATION D'UNE PERSONNE ****");
		System.out.println("************************************");
		Personne persAJour = bll.selectById(3);
		System.out.println(persAJour);
	}
}
