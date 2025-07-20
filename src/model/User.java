// User.java


package model;

public abstract class User {
    protected String username;
    protected String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public abstract void showMenu();

    public boolean checkLogin(String u, String p) {
        return this.username.equals(u) && this.password.equals(p);
    }
}

