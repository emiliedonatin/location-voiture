package fr.treeptik.locationvoiture.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Voiture")
public class Voiture implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IdVoiture")
	private Integer id;

	@Column(name = "Marque")
	@NotEmpty
	// on peut préciser le message d'erreur en faisant message=""
	private String marque;

	@Column(name = "Modele")
	@NotBlank
	// on peut préciser le message d'erreur en faisant message=""
	@Size(min = 3, max = 10)
	// on peut préciser le message d'erreur en faisant message=""
	private String modele;

	@OneToMany(mappedBy="voiture")
	private List<Reservation> reservations;

	// @DateTimeFormat(pattern="dd/MM/yyyy")
	// @Future signifie que la date doit être supérieure à la date du jour
	// private Date dateMiseEnCirculation;

	public Voiture() {

	}

	public Voiture(Integer id, String marque, String modele, List<Reservation> reservations) {
		super();
		this.id = id;
		this.marque = marque;
		this.modele = modele;
		this.reservations = reservations;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

}
