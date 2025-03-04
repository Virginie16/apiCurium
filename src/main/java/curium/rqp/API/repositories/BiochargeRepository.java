package curium.rqp.API.repositories;

import curium.rqp.API.models.Biocharge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BiochargeRepository extends JpaRepository<Biocharge, String> {
	Logger logger = LoggerFactory.getLogger(BiochargeRepository.class);
	@Query("SELECT l FROM Biocharge l JOIN Site sc ON l.site = sc.trigrammeSite " +
			"WHERE sc.nomSite = :site " +
			"AND l.produit = :produit ")
	List<Biocharge> findBySiteProduitAndPeriode(
			@Param("site") String site,
			@Param("produit") String produit

	);
	default List<Biocharge> findBySiteProduitAndPeriodeWithLogging(String site, String produit) {
		logger.info("Executing query with site: {} and produit: {}", site, produit);
		return findBySiteProduitAndPeriode(site, produit);
	}
}
