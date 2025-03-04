package curium.rqp.API.services;

import curium.rqp.API.models.ChangeControl;
import curium.rqp.API.repositories.ChangeControlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChangeControlService {

	@Autowired
	private ChangeControlRepository changeControlRepository;

	public List<ChangeControl> getLotsFiltresChange(String site, String produit) {
		return changeControlRepository.findBySiteProduitWithLogging(site, produit);
	}
}
