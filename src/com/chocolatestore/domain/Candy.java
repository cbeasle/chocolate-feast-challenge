package com.chocolatestore.domain;

/**
 * Created by cbeasle on 2/9/18.
 */
public class Candy {
    private CandyType type;

    public Candy(String type) throws IllegalArgumentException {
        this.setType(type);
        if (this.getType() == null){
            throw new IllegalArgumentException("Invalid com.chocolatestore.domain.CandyType: " + type);
        }
    }
    public Candy(CandyType type){
        this.setType(type);
    }

    //getters and setters
    public CandyType getType() {
        return type;
    }

    public void setType(CandyType type) {
        this.type = type;
    }

    public void setType(String type) {
        this.type = CandyType.fromValue(type);
    }

    public CandyType getPromoCandyType(){
        CandyType promoCandyType = null;

        switch( this.getType() ){
            case MILK:
                promoCandyType = CandyType.SUGAR_FREE;
                break;
            case SUGAR_FREE:
                promoCandyType = CandyType.DARK;
                break;
            case WHITE:
                promoCandyType = CandyType.SUGAR_FREE;
                break;
            case DARK:
                promoCandyType = null;
                break;
        }


        return promoCandyType;
    }
}
