package com.com.Enum;

/**
 * Created by arvin on 2018/1/13.
 */
public enum LastNameEnum {
    PERSON1(1,"zhangjie"),
    PERSON2(2,"libin"),
    PERSON3(3,"zhaotianying"),
    PERSON4(4,"wanglijia");
    private int key;
    private String name;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    LastNameEnum(int key, String name) {
        this.key = key;
        this.name = name;
    }
}
