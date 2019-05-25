package com.dna.store.discount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiscountController {
	
	@Autowired
	IDiscountService discountService;

	@PostMapping("calculate-discount")
	public Bill calculateDiscount( @RequestBody Bill bill ) {
		
		return discountService.calculateDiscount(bill);
	}
}
