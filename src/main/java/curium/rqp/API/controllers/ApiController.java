package curium.rqp.API.controllers;

import curium.rqp.API.dto.LoginDto;
import curium.rqp.API.models.Biocharge;
import curium.rqp.API.models.ChangeControl;
import curium.rqp.API.services.BiochargeService;
import curium.rqp.API.services.ChangeControlService;
import curium.rqp.API.services.ProduitService;
import curium.rqp.API.services.SiteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ApiController {

	private SiteService siteService;
	private ProduitService produitService;
	private BiochargeService biochargeService;
	private ChangeControlService changeControlService;
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	public ApiController(SiteService siteService, ProduitService produitService, BiochargeService biochargeService, ChangeControlService changeControlService) {
		this.siteService = siteService;
		this.produitService = produitService;
		this.biochargeService = biochargeService;
		this.changeControlService = changeControlService;
	}

	@PostMapping("/login")
	public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto){
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				loginDto.getUsername(), loginDto.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
	}

//	@GetMapping("/selection")
//	public String showSelectionPage() {
//		return "selection"; // Doit correspondre au nom du fichier Thymeleaf (selection.html)
//	}
	@GetMapping("/sites")
	public ResponseEntity<List<String>> getSites() {
		return ResponseEntity.ok(siteService.getAllSites());
	}

	@CrossOrigin
	@GetMapping("/produits")
	public ResponseEntity<List<String>> getProduits() {
		return ResponseEntity.ok(produitService.findAll());
	}

	@GetMapping("/biocharges")
	public ResponseEntity<?> getBiocharges(
			@RequestParam(name = "site", required = false) String site,
			@RequestParam(name = "produit", required = false) String produit) {

		List<Biocharge> biocharges = biochargeService.getLotsFiltrés(site, produit);

		if (biocharges.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(Map.of("message", "Aucun lot ne correspond aux critères sélectionnés", "produit", produit, "site", site));
		}

		return ResponseEntity.ok(biocharges);
	}

	@GetMapping("/changecontrols")
	public ResponseEntity<?> getChangeControls(
			@RequestParam(name = "site", required = false) String site,
			@RequestParam(name = "produit", required = false) String produit) {

		List<ChangeControl> changeControls = changeControlService.getLotsFiltresChange(site, produit);

		if (changeControls.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(Map.of("message", "Aucun lot ne correspond aux critères sélectionnés", "produit", produit, "site", site));
		}

		return ResponseEntity.ok(changeControls);
	}

}
