/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
/**
 *
 * @author HoaiNhat
 */
import java.io.Serializable;
import java.util.Objects;

public class Librarian implements Serializable {
    private String id;
    private String name;
    private String email;
    private String username;
    private String password;
    private String role;

    // Constructor có đầy đủ tham số
    public Librarian(String id, String name, String email, String username, String password, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Constructor mặc định BẮT BUỘC để ObjectInputStream hoạt động tốt
    public Librarian() {
    }

    // Getters & Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Email: %s | Username: %s | Role: %s",
                id, name, email, username, role);
    }
}
