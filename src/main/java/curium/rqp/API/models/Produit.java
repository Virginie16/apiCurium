package curium.rqp.API.models;

import jakarta.persistence.*;

@Entity
@Table(name = "produit")
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nom_produit", length = 20)
	private String nomProduit;

	@Column(name = "sigle_produit", length = 10)
	private String sigleProduit;

	public Produit(Long id, String nomProduit, String sigleProduit) {
		this.id = id;
		this.nomProduit = nomProduit;
		this.sigleProduit = sigleProduit;
	}

	public Produit() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public String getSigleProduit() {
		return sigleProduit;
	}

	public void setSigleProduit(String sigleProduit) {
		this.sigleProduit = sigleProduit;
	}
}
