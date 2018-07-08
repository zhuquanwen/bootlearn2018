package com.zqw.springboot.learn.boot.validate.custom;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum  Sex {
    MALE(0),FEMALE(1);
    private Integer code;

    Sex(Integer code) {
        this.code = code;
    }

    @JsonValue
    public Integer getCode() {
        return code;
    }

    @JsonCreator
    public static Sex getGender(Integer code) {
        for (Sex gender : Sex.values()) {
            if (gender.getCode().equals(code)) {
                return gender;
            }
        }
        return null;
    }
}
