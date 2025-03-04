package curium.rqp.API.services;

import curium.rqp.API.models.Produit;
import curium.rqp.API.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProduitService {

	@Autowired
	private ProduitRepository produitRepository;

	public List<String> findAll() {
		return produitRepository.findAll()
				.stream()
				.map(Produit::getNomProduit)
				.collect(Collectors.toList());
	}
}
