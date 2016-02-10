package dykim.Store.cmm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dykim.Store.order.vo.Order;

@RestController
public class CommonController {
	@RequestMapping(value = "/users/login", method = RequestMethod.POST)
	public boolean loginCheck(Order order){
		//TODO 로그인 구현 
		return true;
	}
}
