package com.infy.aeroFlights.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.infy.aeroFlights.dto.OfferStatus;

@Entity
@Table(name="offer")
public class Offer {

	@Id
	@Column(name = "offer_title")
	private String offerTitle;
	
	@Column(name = "discount")
	private Double discount;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private OfferStatus status;

	public Offer() {}
	
	public Offer(String offerTitle, Double discount, OfferStatus status) {
		super();
		this.offerTitle = offerTitle;
		this.discount = discount;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Offer [offerTitle=" + offerTitle + ", discount=" + discount + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((discount == null) ? 0 : discount.hashCode());
		result = prime * result + ((offerTitle == null) ? 0 : offerTitle.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Offer other = (Offer) obj;
		if (discount == null) {
			if (other.discount != null)
				return false;
		} else if (!discount.equals(other.discount))
			return false;
		if (offerTitle == null) {
			if (other.offerTitle != null)
				return false;
		} else if (!offerTitle.equals(other.offerTitle))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	public String getOfferTitle() {
		return offerTitle;
	}

	public void setOfferTitle(String offerTitle) {
		this.offerTitle = offerTitle;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public OfferStatus getStatus() {
		return status;
	}

	public void setStatus(OfferStatus status) {
		this.status = status;
	}

	
}
