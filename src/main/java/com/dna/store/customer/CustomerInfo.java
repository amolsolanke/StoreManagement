package com.dna.store.customer;

public class CustomerInfo {

	String firstName;
	String lastNaame;
	Status status;
	
	public enum Status {
		STORE_EMPLOYEE,
		AFFILIATE,
		SILVER_CUSTOMER
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastNaame() {
		return lastNaame;
	}

	public Status getStatus() {
		return status;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastNaame(String lastNaame) {
		this.lastNaame = lastNaame;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastNaame == null) ? 0 : lastNaame.hashCode());
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
		CustomerInfo other = (CustomerInfo) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastNaame == null) {
			if (other.lastNaame != null)
				return false;
		} else if (!lastNaame.equals(other.lastNaame))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CustomerInfo [firstName=" + firstName + ", lastNaame=" + lastNaame + ", status=" + status + "]";
	}
	
}
