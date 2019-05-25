package com.dna.store.product;

public class ProductInfo {

	String name;
	Double price;
	Double discountedPrice;
	Type type;
	Integer quantity;
	
	public enum Type {
		GROCERY ,
		HOUSEHOLD ,
		BEVERAGES ,
		PERSONAL_CARE ,
		DAIRY ,
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public Double getDiscountedPrice() {
		return discountedPrice;
	}

	public Type getType() {
		return type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setDiscountedPrice(Double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((discountedPrice == null) ? 0 : discountedPrice.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		ProductInfo other = (ProductInfo) obj;
		if (discountedPrice == null) {
			if (other.discountedPrice != null)
				return false;
		} else if (!discountedPrice.equals(other.discountedPrice))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductInfo [name=" + name + ", price=" + price + ", discountedPrice=" + discountedPrice + ", type="
				+ type + ", quantity=" + quantity + "]";
	}

}
