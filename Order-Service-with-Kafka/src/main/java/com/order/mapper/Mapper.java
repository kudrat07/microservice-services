package com.order.mapper;

import org.springframework.stereotype.Component;

import com.order.dto.OrderDto;
import com.order.entity.OrderEntity;

@Component
public class Mapper {
	
	public OrderEntity toEntity(OrderDto orderDto) {
		
		OrderEntity entity = new OrderEntity();
		entity.setItemName(orderDto.getItemName());
		entity.setDescription(orderDto.getDescription());
		entity.setStatus(orderDto.getStatus());
		
		return entity;
		
	}
	
	public OrderDto toDto(OrderEntity entity) {
		
		OrderDto dto = new OrderDto();
		dto.setId(entity.getId());
		dto.setItemName(entity.getItemName());
		dto.setDescription(entity.getDescription());
		dto.setStatus(entity.getStatus());
		
		return dto;
		
		
	}

}
