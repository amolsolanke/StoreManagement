# StoreManagement

This project publishes RESTFull web sevice to calculate discounted total.
Criteri for discount is:
1. If the user is an employee of the store, he gets a 30% discount
2. If the user is an affiliate of the store, he gets a 10% discount
3. If the user has been a customer for over 2 years, he gets a 5% discount.
4. For every $100 on the bill, there would be a $ 5 discount (e.g. for $ 990, you get $ 45 as a discount).
5. The percentage based discounts do not apply on groceries.
6. A user can get only one of the percentage based discounts on a bill.


Sample request:
Endpoint: store/calculate-discount
Request Body:
{
	"customerInfo" :
	{
		"firstName":"Amol",
		"lastNaame":"Solanke",
		"status":"SILVER_CUSTOMER"
	},
	"productList" : 
	[ 
		{
			"name" : "Tata Salt",
			"price":18.0,
			"type":"GROCERY",
			"quantity":10
		},
		{
			"name" : "Hair Dryer",
			"price":1200.0,
			"type":"PERSONAL_CARE",
			"quantity":1
		}
	]
}

Response Body:
{
    "customerInfo": {
        "firstName": "Amol",
        "lastNaame": "Solanke",
        "status": "SILVER_CUSTOMER"
    },
    "productList": [
        {
            "name": "Tata Salt",
            "price": 18,
            "discountedPrice": 18,
            "type": "GROCERY",
            "quantity": 10
        },
        {
            "name": "Hair Dryer",
            "price": 1200,
            "discountedPrice": 1140,
            "type": "PERSONAL_CARE",
            "quantity": 1
        }
    ],
    "total": 1380,
    "discountedTotal": 1255
}
