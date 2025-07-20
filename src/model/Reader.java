package model;

import java.io.Serializable;

public class Reader extends User implements Serializable {
    private String idReader;
    private String type;
    private String sex;

    public Reader(String username, String password, String idReader, String type, String sex) {
        super(username, password); // gọi constructor từ lớp cha User
        this.idReader = idReader;
        this.type = type;
        this.sex = sex;
    }

    public String getIdReader() {
        return idReader;
    }

    public void setIdReader(String idReader) {
        this.idReader = idReader;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public void showMenu() {
        System.out.println("=== Reader Menu ===");
        System.out.println("1. View borrowed books");
        System.out.println("2. Search books");
        System.out.println("0. Exit");
    }

    @Override
    public String toString() {
        return "Reader [username=" + username + ", idReader=" + idReader +
               ", type=" + type + ", sex=" + sex + ", password=" + password + "]";
    }
}
