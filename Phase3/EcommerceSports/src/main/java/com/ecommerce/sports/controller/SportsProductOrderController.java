package com.ecommerce.sports.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.sports.models.SportsProductOrder;
import com.ecommerce.sports.service.SportsProductOrderMySQLDAO;


@RestController
@RequestMapping(path = "/ecommerce")
public class SportsProductOrderController {
	
	@Autowired
	SportsProductOrderMySQLDAO pDAO;
	
	@GetMapping(path ="/orders")
	public List<SportsProductOrder> getPurchaseOrders() {
		
	
		List<SportsProductOrder> results = pDAO.getAllPurchaseOrders();
		System.out.println(results.size()+"--------------------------------");
		
		return results;
	}

	@GetMapping("/orderFilter")
    public List<SportsProductOrder> getOrders( @RequestBody Map<String, String> rMap) throws Exception {
        if (rMap == null) {
            return (List<SportsProductOrder>) ResponseEntity
                    .status(HttpStatus.OK)
                    .body(pDAO.getAllPurchaseOrders());
        } else {
            String date = rMap.get("date");
            String category = rMap.get("category");
            return (pDAO.getFilteredOrders(date, category));
        }
    }
}
