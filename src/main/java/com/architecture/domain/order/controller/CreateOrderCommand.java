package com.architecture.domain.order.controller;

import lombok.Value;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Value
public class CreateOrderCommand implements java.io.Serializable{
    @NotBlank(message = "产品Id不能为空")
    private String proId;

    @Min(value = 1, message = "产品数量必须大于0")
    private int number;
    
}
