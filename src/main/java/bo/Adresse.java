package bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "adresses")
public class Adresse {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String ville;
	private String rue;
	
	public Adresse() {}
	
	public Adresse(String ville, String rue) {
		this.ville = ville;
		this.rue = rue;
	}

	@Override
	public String toString() {
		return "Adresse [id=" + id + ", ville=" + ville + ", rue=" + rue + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}
}
