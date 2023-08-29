package com.app.services;

import com.app.dtos.PlaceOrderDto;

public interface OrdersService {
	String placeOrder(PlaceOrderDto placeOrderDto);
}
