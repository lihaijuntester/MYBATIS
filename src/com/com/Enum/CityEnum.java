package com.com.Enum;

/**
 * Created by arvin on 2018/1/6.
 */
public enum CityEnum {
    RED("红色", 1),
    GREEN("绿色", 2),
    BLANK("白色", 3),
    YELLO("黄色", 4);
    private String name;
    private int index;
    private CityEnum(String name, int index){
        this.index = index;
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getIndex(){
        return index;
    }
    public void setIndex(int index){
        this.index = index;
    }

}
