package com.changgou.order.controller;

import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import com.changgou.order.pojo.OrderItem;
import com.changgou.order.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Ayden
 * @Date 2019/9/1 10:50
 * @Description
 * @Version
 **/
@RestController
@RequestMapping("/cart")
@CrossOrigin
public class CartController {
    @Autowired
    private CartService cartService;

    @RequestMapping("/add")
    public Result addCart(Long id, Integer num) {
        String username ="zhangsan";
        cartService.addCart(id, num, username);
        return new Result(true, StatusCode.OK, "添加购物车成功 ");
    }

    @RequestMapping("/list")
    public Result<OrderItem> getCart() {
        String username ="zhangsan";
        return new Result(true, StatusCode.OK, "查询购物车成功");
    }
}


