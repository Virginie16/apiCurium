package curium.rqp.API.services;

import curium.rqp.API.models.Site;
import curium.rqp.API.repositories.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SiteService {

	@Autowired
	private SiteRepository siteRepository;

	public List<String> getAllSites() {
		return siteRepository.findAll()
				.stream()
				.map(Site::getNomSite)
				.collect(Collectors.toList());
	}
}
