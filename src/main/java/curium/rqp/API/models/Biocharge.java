package curium.rqp.API.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "biocharge")
public class Biocharge {


	@Id
	@Column(name = "numero_lot", length = 50)
	private String numeroLot;

	@Column(name = "synthetiseur_utilise", length = 10)
	private String synthetiseurUtilise;

	@Column(name = "date_reception_cq")
	private LocalDate dateReceptionCQ;

	@Column(name = "site", length = 100)
	private String site;

	@Column(name = "date_realisation")
	private LocalDate dateRealisation;

	@Column(name = "numero_flacon", length = 20)
	private String numeroFlacon;

	@Column(name = "jour_reception_cq")
	private LocalDate jourReceptionCQ;

	@Column(name = "rapport_icare")
	private LocalDate rapportIcare;

	@Column(name = "DDL_date_transmission")
	private LocalDate ddlDateTransmission;

	@Column(name = "date_reception_PHR")
	private LocalDate dateReceptionPHR;

	@Column(name = "statut", length = 10)
	private String statut;

	@Column(name = "signature_PHR")
	private LocalDate signaturePHR;

	@Column(name = "reception_SM")
	private LocalDate receptionSM;

	@Column(name = "produit", length = 100) // Ajout du produit
	private String produit;

	@ManyToOne
	@JoinColumn(name = "site", referencedColumnName = "site", insertable = false, updatable = false)
	@JoinColumn(name = "produit", referencedColumnName = "produit", insertable = false, updatable = false)
	private ChangeControl changeControl;

	@ManyToOne
	@JoinColumn(name = "site", referencedColumnName = "trigramme_site", insertable = false, updatable = false)
	private Site siteEntity;

	public Biocharge(String numeroLot, String synthetiseurUtilise, LocalDate dateReceptionCQ, String site, LocalDate dateRealisation, String numeroFlacon, LocalDate jourReceptionCQ, LocalDate rapportIcare, LocalDate ddlDateTransmission, LocalDate dateReceptionPHR, String statut, LocalDate signaturePHR, LocalDate receptionSM, String produit, ChangeControl changeControl, Site siteEntity) {
		this.numeroLot = numeroLot;
		this.synthetiseurUtilise = synthetiseurUtilise;
		this.dateReceptionCQ = dateReceptionCQ;
		this.site = site;
		this.dateRealisation = dateRealisation;
		this.numeroFlacon = numeroFlacon;
		this.jourReceptionCQ = jourReceptionCQ;
		this.rapportIcare = rapportIcare;
		this.ddlDateTransmission = ddlDateTransmission;
		this.dateReceptionPHR = dateReceptionPHR;
		this.statut = statut;
		this.signaturePHR = signaturePHR;
		this.receptionSM = receptionSM;
		this.produit = produit;
		this.changeControl = changeControl;
		this.siteEntity = siteEntity;
	}
	public Biocharge() {}

	public String getNumeroLot() {
		return numeroLot;
	}

	public void setNumeroLot(String numeroLot) {
		this.numeroLot = numeroLot;
	}

	public String getSynthetiseurUtilise() {
		return synthetiseurUtilise;
	}

	public void setSynthetiseurUtilise(String synthetiseurUtilise) {
		this.synthetiseurUtilise = synthetiseurUtilise;
	}

	public LocalDate getDateReceptionCQ() {
		return dateReceptionCQ;
	}

	public void setDateReceptionCQ(LocalDate dateReceptionCQ) {
		this.dateReceptionCQ = dateReceptionCQ;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public LocalDate getDateRealisation() {
		return dateRealisation;
	}

	public void setDateRealisation(LocalDate dateRealisation) {
		this.dateRealisation = dateRealisation;
	}

	public String getNumeroFlacon() {
		return numeroFlacon;
	}

	public void setNumeroFlacon(String numeroFlacon) {
		this.numeroFlacon = numeroFlacon;
	}

	public LocalDate getJourReceptionCQ() {
		return jourReceptionCQ;
	}

	public void setJourReceptionCQ(LocalDate jourReceptionCQ) {
		this.jourReceptionCQ = jourReceptionCQ;
	}

	public LocalDate getRapportIcare() {
		return rapportIcare;
	}

	public void setRapportIcare(LocalDate rapportIcare) {
		this.rapportIcare = rapportIcare;
	}

	public LocalDate getDdlDateTransmission() {
		return ddlDateTransmission;
	}

	public void setDdlDateTransmission(LocalDate ddlDateTransmission) {
		this.ddlDateTransmission = ddlDateTransmission;
	}

	public LocalDate getDateReceptionPHR() {
		return dateReceptionPHR;
	}

	public void setDateReceptionPHR(LocalDate dateReceptionPHR) {
		this.dateReceptionPHR = dateReceptionPHR;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public LocalDate getSignaturePHR() {
		return signaturePHR;
	}

	public void setSignaturePHR(LocalDate signaturePHR) {
		this.signaturePHR = signaturePHR;
	}

	public LocalDate getReceptionSM() {
		return receptionSM;
	}

	public void setReceptionSM(LocalDate receptionSM) {
		this.receptionSM = receptionSM;
	}

	public String getProduit() {
		return produit;
	}

	public void setProduit(String produit) {
		this.produit = produit;
	}

	public ChangeControl getChangeControl() {
		return changeControl;
	}

	public void setChangeControl(ChangeControl changeControl) {
		this.changeControl = changeControl;
	}

	public Site getSiteEntity() {
		return siteEntity;
	}

	public void setSiteEntity(Site siteEntity) {
		this.siteEntity = siteEntity;
	}
}
