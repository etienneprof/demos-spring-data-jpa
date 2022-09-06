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
 * Cette servlet teste les methodes personnalisees du dao
 */
@WebServlet("/avance")
public class DeuxiemeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private PersonneBLL bll;
	
	@Override
	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Insertion d'une personne supplementaire
		Adresse adresse = new Adresse("New York", "Rue Obama");
		Personne personne = new Personne("KEVIN", "Bart", adresse);
		bll.insert(personne);
		
		// 2. Lister toutes les personnes dont le prenom termine par un t (clement, bart)
		System.out.println("******************************************");
		System.out.println("*AFFICHAGE DES PERSONNES FINISSANT PAR T *");
		System.out.println("******************************************");
		List<Personne> personnes = bll.findByPrenomEndingWith("t");
		for (Personne current : personnes) {
			System.out.println(current);
		}
		// 3. Lister toutes les personnes qui habite a Nantes (jointure)
		System.out.println("******************************************");
		System.out.println("*AFFICHAGE DES PERSONNES VIVANT A NANTES *");
		System.out.println("******************************************");
		personnes = bll.findByAdresseVille("Nantes");
		for (Personne current : personnes) {
			System.out.println(current);
		}
		
		// 4. Lister toutes les personnes par ordre alphabetique sur le nom
		System.out.println("******************************************");
		System.out.println("*AFFICHAGE DES PERSONNES PAR ORDRE ALPHA *");
		System.out.println("******************************************");
		personnes = bll.findByOrderByNom();
		for (Personne current : personnes) {
			System.out.println(current);
		}
		
		// 5. Rechercher la personne qui s'appelle Etienne Cassin
		System.out.println("******************************************");
		System.out.println("*AFFICHAGE DE ETIENNE CASSIN *");
		System.out.println("******************************************");
		Personne pers = bll.findByNomAndPrenom("CASSIN", "Etienne");
		System.out.println(pers);
	}
}
