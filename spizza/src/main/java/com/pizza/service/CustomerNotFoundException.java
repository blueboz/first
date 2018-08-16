package com.pizza.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason="CustomerNotFound",
		value=HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException{

}
