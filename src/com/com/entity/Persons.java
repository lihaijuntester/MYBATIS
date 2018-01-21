package com.com.entity;

/**
 * Created by arvin on 2018/1/13.
 */
public class Persons {
    private int id;
    private String L_name;
    private String F_name;
    private String A_addres;
    private String C_city;

    @Override
    public String toString() {
        return "LastNameEnum{" +
                "id=" + id +
                ", L_name='" + L_name + '\'' +
                ", F_name='" + F_name + '\'' +
                ", A_addres='" + A_addres + '\'' +
                ", C_city='" + C_city + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getL_name() {
        return L_name;
    }

    public void setL_name(String l_name) {
        L_name = l_name;
    }

    public String getF_name() {
        return F_name;
    }

    public void setF_name(String f_name) {
        F_name = f_name;
    }

    public String getA_addres() {
        return A_addres;
    }

    public void setA_addres(String a_addres) {
        A_addres = a_addres;
    }

    public String getC_city() {
        return C_city;
    }

    public void setC_city(String c_city) {
        C_city = c_city;
    }

}
