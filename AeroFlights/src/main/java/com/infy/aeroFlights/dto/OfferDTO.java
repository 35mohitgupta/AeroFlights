package com.infy.aeroFlights.dto;

import com.infy.aeroFlights.entity.Offer;

public class OfferDTO {

	private String offerTitle;
	
	private Double discount;

	private OfferStatus status;
	
	
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
		OfferDTO other = (OfferDTO) obj;
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
	
	public Offer toEntity() {
		Offer offerEntity = new Offer();
		offerEntity.setDiscount(discount);
		offerEntity.setOfferTitle(offerTitle);
		offerEntity.setStatus(status);
		return offerEntity;
	}
	
	public static OfferDTO toModel(Offer offerEntity) {
		OfferDTO offer = new OfferDTO();
		offer.discount = offerEntity.getDiscount();
		offer.offerTitle = offerEntity.getOfferTitle();
		offer.status = offerEntity.getStatus();
		return offer;
	}

	@Override
	public String toString() {
		return "OfferDTO [offerTitle=" + offerTitle + ", discount=" + discount + ", status=" + status + "]";
	}
	
}
