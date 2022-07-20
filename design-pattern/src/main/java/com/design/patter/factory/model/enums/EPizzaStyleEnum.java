package com.design.patter.factory.model.enums;

import lombok.Getter;

@Getter
public enum EPizzaStyleEnum {
    NY("ny",""),
    CHICAGO("chicago",""),
    ;
    private String style;
    private String desc;

    EPizzaStyleEnum(String style, String desc) {
        this.style = style;
        this.desc = desc;
    }
}
