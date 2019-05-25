package com.dna.store.discount;

import java.util.List;

import com.dna.store.customer.CustomerInfo;
import com.dna.store.product.ProductInfo;

public class Bill {

	CustomerInfo customerInfo;
	List<ProductInfo> productList;
	Double total;
	Double discountedTotal;
	
	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}

	public List<ProductInfo> getProductList() {
		return productList;
	}

	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}

	public void setProductList(List<ProductInfo> productList) {
		this.productList = productList;
	}

	public Double getTotal() {
		return total;
	}

	public Double getDiscountedTotal() {
		return discountedTotal;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public void setDiscountedTotal(Double discountedTotal) {
		this.discountedTotal = discountedTotal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerInfo == null) ? 0 : customerInfo.hashCode());
		result = prime * result + ((discountedTotal == null) ? 0 : discountedTotal.hashCode());
		result = prime * result + ((productList == null) ? 0 : productList.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
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
		Bill other = (Bill) obj;
		if (customerInfo == null) {
			if (other.customerInfo != null)
				return false;
		} else if (!customerInfo.equals(other.customerInfo))
			return false;
		if (discountedTotal == null) {
			if (other.discountedTotal != null)
				return false;
		} else if (!discountedTotal.equals(other.discountedTotal))
			return false;
		if (productList == null) {
			if (other.productList != null)
				return false;
		} else if (!productList.equals(other.productList))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bill [customerInfo=" + customerInfo + ", productList=" + productList + ", total=" + total
				+ ", discountedTotal=" + discountedTotal + "]";
	}

}
