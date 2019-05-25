package com.dna.store.discount;

import org.springframework.stereotype.Service;

import com.dna.store.customer.CustomerInfo;
import com.dna.store.product.ProductInfo;

@Service
public class DiscountServiceImpl implements IDiscountService {

	@Override
	public Bill calculateDiscount(Bill bill) {

		final Double discountPercentage;
		bill.setTotal(0d);
		bill.setDiscountedTotal(0d);
		if (bill.getCustomerInfo().getStatus().equals(CustomerInfo.Status.STORE_EMPLOYEE))
			discountPercentage = (30d / 100);
		else if (bill.getCustomerInfo().getStatus().equals(CustomerInfo.Status.AFFILIATE))
			discountPercentage = (10d / 100);
		else if (bill.getCustomerInfo().getStatus().equals(CustomerInfo.Status.SILVER_CUSTOMER))
			discountPercentage =  (5d / 100);
		else
			discountPercentage = 0d;

		bill.getProductList().stream().forEach(p -> {
			if (!p.getType().equals(ProductInfo.Type.GROCERY))
				p.setDiscountedPrice(p.getPrice() - (p.getPrice() * discountPercentage));
			else
				p.setDiscountedPrice(p.getPrice());

			bill.setDiscountedTotal(bill.getDiscountedTotal() + (p.getDiscountedPrice() * p.getQuantity()));
			bill.setTotal(bill.getTotal() + (p.getPrice() * p.getQuantity()));

		});

		Integer discountOnTotalBill =  ((int)(bill.getDiscountedTotal() / 100) * 5);
		bill.setDiscountedTotal(bill.getDiscountedTotal() - discountOnTotalBill);
		return bill;
	}

}
