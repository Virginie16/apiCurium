package curium.rqp.API.services;

import curium.rqp.API.models.Biocharge;
import curium.rqp.API.repositories.BiochargeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BiochargeService {

	@Autowired
	private BiochargeRepository biochargeRepository;

	public List<Biocharge> getLotsFiltrés(String site, String produit) {
		return biochargeRepository.findBySiteProduitAndPeriodeWithLogging(site, produit);
	}
}
