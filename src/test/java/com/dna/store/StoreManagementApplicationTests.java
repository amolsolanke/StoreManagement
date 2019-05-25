package com.dna.store;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dna.store.customer.CustomerInfo;
import com.dna.store.discount.Bill;
import com.dna.store.discount.IDiscountService;
import com.dna.store.product.ProductInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StoreManagementApplicationTests {

	@Autowired
	IDiscountService discountService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void employeeDiscountTest() {

		Bill bill = getBill();
		bill.getCustomerInfo().setStatus(CustomerInfo.Status.STORE_EMPLOYEE);
		discountService.calculateDiscount(bill);
		// 180 + 840(discounted price for hair dryer) = 1020 - (50 i.e. 5 dollar
		// discount per 100 dollar)
		assertEquals(Double.valueOf(970), bill.getDiscountedTotal());
		assertEquals(Double.valueOf(1380), bill.getTotal());

	}

	@Test
	public void affiliateDiscountTest() {

		Bill bill = getBill();
		bill.getCustomerInfo().setStatus(CustomerInfo.Status.AFFILIATE);
		discountService.calculateDiscount(bill);
		// 180(salt price) + 1080 (discounted price for hair dryer) = 1260 - 60
		assertEquals(Double.valueOf(1200), bill.getDiscountedTotal());
		assertEquals(Double.valueOf(1380), bill.getTotal());

	}

	@Test
	public void silverCustomerDiscountTest() {

		Bill bill = getBill();
		bill.getCustomerInfo().setStatus(CustomerInfo.Status.SILVER_CUSTOMER);
		discountService.calculateDiscount(bill);
		// 180 + 1140(discounted price for hair dryer) = 1320 - 65
		assertEquals(Double.valueOf(1255), bill.getDiscountedTotal());
		assertEquals(Double.valueOf(1380), bill.getTotal());

	}

	private Bill getBill() {
		Bill bill = new Bill();
		List<ProductInfo> productList = new ArrayList<>();

		CustomerInfo custInfo = new CustomerInfo();
		custInfo.setFirstName("Amol");
		custInfo.setLastNaame("Solanke");

		ProductInfo product1Info = new ProductInfo();
		product1Info.setName("Tata Salt");
		product1Info.setPrice(18d);
		product1Info.setQuantity(10);
		product1Info.setType(ProductInfo.Type.GROCERY);

		ProductInfo product2Info = new ProductInfo();
		product2Info.setName("Hair Dryer");
		product2Info.setPrice(1200d);
		product2Info.setQuantity(1);
		product2Info.setType(ProductInfo.Type.PERSONAL_CARE);

		productList.add(product1Info);
		productList.add(product2Info);

		bill.setCustomerInfo(custInfo);
		bill.setProductList(productList);

		return bill;

	}
}
