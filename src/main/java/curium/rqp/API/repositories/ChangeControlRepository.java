package curium.rqp.API.repositories;

import curium.rqp.API.models.ChangeControl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChangeControlRepository extends JpaRepository<ChangeControl, String> {
	Logger logger = LoggerFactory.getLogger(ChangeControlRepository.class);
	@Query("SELECT c FROM ChangeControl c " +
			"WHERE c.site = :site " +
			"AND c.produit = :produit")
	List<ChangeControl> findBySiteProduit(
			@Param("site") String site,
			@Param("produit") String produit

	);
	default List<ChangeControl> findBySiteProduitWithLogging(String site, String produit) {
		logger.info("Executing query with site: {} and produit: {}", site, produit);
		return findBySiteProduit(site, produit);
	}

}
