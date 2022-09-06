package dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bo.Personne;

@Repository
public interface PersonneDAO extends JpaRepository<Personne, Integer> {
	List<Personne> findByPrenomEndingWith(String chaine);
	List<Personne> findByAdresseVille(String ville);
	List<Personne> findByOrderByNom();
	Personne findByNomAndPrenom(String nom, String prenom);
}
