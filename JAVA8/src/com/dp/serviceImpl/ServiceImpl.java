package com.dp.serviceImpl;

import com.dp.service.messaginService;

public class ServiceImpl implements messaginService {

	@Override
	public void sendMessage(String message) {

		System.out.println("sending message " + message);
	}

	

}
