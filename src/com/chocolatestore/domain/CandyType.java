package com.chocolatestore.domain;

/**
 * Created by cbeasle on 2/9/18.
 */
public enum CandyType {
    MILK("milk"),
    DARK("dark"),
    SUGAR_FREE("sugar free"),
    WHITE("white");

    private final String value;

    CandyType (String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    static public CandyType fromValue(String v) {
        for (CandyType c : CandyType
                .values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        return null;
    }

}
