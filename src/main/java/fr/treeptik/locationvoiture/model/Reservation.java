package fr.treeptik.locationvoiture.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Reservation")
public class Reservation implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IdReservation")
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DateReservation")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dateReservation;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DatePriseVoiture")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date datePriseVoiture;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DateRetourVoiture")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date retourVoiture;
	
	@ManyToOne
	@JoinColumn(name="IdClient")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="IdVoiture")
	private Voiture voiture;
	
	public Reservation() {
		
	}

	public Reservation(Integer id, Date dateReservation, Date datePriseVoiture, Date retourVoiture, Client client, Voiture voiture) {
		super();
		this.id = id;
		this.dateReservation = dateReservation;
		this.datePriseVoiture = datePriseVoiture;
		this.retourVoiture = retourVoiture;
		this.client = client;
		this.voiture = voiture;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}

	public Date getDatePriseVoiture() {
		return datePriseVoiture;
	}

	public void setDatePriseVoiture(Date datePriseVoiture) {
		this.datePriseVoiture = datePriseVoiture;
	}

	public Date getRetourVoiture() {
		return retourVoiture;
	}

	public void setRetourVoiture(Date retourVoiture) {
		this.retourVoiture = retourVoiture;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}
	
	

}
