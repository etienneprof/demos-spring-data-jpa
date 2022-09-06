package bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.Personne;
import dal.PersonneDAO;

@Service
public class PersonneBLL {
	@Autowired
	private PersonneDAO dao;
	
	public List<Personne> selectAll() {
		return dao.findAll();
	}
	
	public Personne selectById(int id) {
		return dao.findById(id).get();
	}
	
	public void insert(Personne personne) {
		dao.save(personne);
	}
	
	public void update(Personne personne) {
		dao.save(personne);
	}
	
	public void delete(Personne personne) {
		dao.delete(personne);
	}
	
	public void delete(int id) {
		dao.deleteById(id);
	}
	
	public List<Personne> findByPrenomEndingWith(String chaine) {
		return dao.findByPrenomEndingWith(chaine);
	}
	
	public List<Personne> findByAdresseVille(String ville) {
		return dao.findByAdresseVille(ville);
	}
	
	public List<Personne> findByOrderByNom() {
		return dao.findByOrderByNom();
	}
	
	public Personne findByNomAndPrenom(String nom, String prenom) {
		return dao.findByNomAndPrenom(nom, prenom);
	}
}
