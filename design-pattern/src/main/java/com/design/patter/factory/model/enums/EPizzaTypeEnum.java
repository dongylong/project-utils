package com.design.patter.factory.model.enums;

import lombok.Getter;

@Getter
public enum EPizzaTypeEnum {
    CHEESE("cheese",""),
    PEPPERONI("pepperoni",""),
    CLAIM("claim",""),
    VEGGIE("veggie",""),
    ;
    private String type;
    private String desc;

    EPizzaTypeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
