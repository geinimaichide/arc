package com.architecture.domain.order.controller;

import lombok.Data;
import lombok.Value;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

//@Value
@Data
public class CreateOrderCommand {
    @Valid
    @NotBlank(message = "产品Id不能为空")
    private String proId;

    @Min(value = 1, message = "产品数量必须大于0")
    private int number;

    public CreateOrderCommand(@Valid @NotBlank(message = "产品Id不能为空") String proId, @Min(value = 1, message = "产品数量必须大于0") int number) {
        this.proId = proId;
        this.number = number;
    }

    public CreateOrderCommand() {
    }
}
