package com.order.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.dto.OrderDto;

@RestController
@RequestMapping("/order")
public class OrderController {
	@PostMapping
	public ResponseEntity<OrderDto> placeOrder(OrderDto orderDto) {
		
		return null;
	}

}
