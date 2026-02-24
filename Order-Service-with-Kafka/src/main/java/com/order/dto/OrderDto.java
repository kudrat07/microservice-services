package com.order.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {

	private String id;
	private String itemName;
	private String description;
	private String status;

}
