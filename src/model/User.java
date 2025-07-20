// User.java
package model;

public abstract class User {
    protected String username;
    protected String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String inputUser, String inputPass) {
        return this.username.equals(inputUser) && this.password.equals(inputPass);
    }

    public abstract void showMenu();
}
