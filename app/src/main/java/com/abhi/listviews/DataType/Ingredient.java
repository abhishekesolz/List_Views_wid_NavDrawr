package com.abhi.listviews.DataType;

/**
 * Created by su on 20/11/15.
 */
public class Ingredient {

    public int id;
    public String name;

    public Ingredient(String name) {
        this.name = name;
    }

    public Ingredient(int id, String name) {
        this.id = id;
        this.name = name;
    }


    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.name.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
