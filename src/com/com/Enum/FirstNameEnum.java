package com.com.Enum;

/**
 * Created by arvin on 2018/1/6.
 */
public enum FirstNameEnum {
    NAME1(1,"Zhangwang"),
    NAME2(2,"Zhangwang1"),
    NAME3(3,"Zhangwang2"),
    NAME4(4,"Zhangwang3"),
    NAME5(5,"Zhangwang4");
    private int index;
    private String msg;
    private FirstNameEnum(int index , String msg) {
        this.index = index;
        this.msg = msg;
    }
    public int getIndex(){
        return  index;
    }
    public void setIndex(int index){
        this.index = index;
    }
    public String getMsg(){
        return  msg;
    }
    public void setMsg(String msg){
        this.msg = msg;
    }
}
