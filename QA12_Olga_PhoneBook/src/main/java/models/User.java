package models;

public class User {

    String email;
    String password;

    public String email(){
        return email;
    }
    public String password(){
        return password;
    }
    public User withEmail(String email){
        this.email = email;
        return this;
    }
    public User withPassword(String password){
        this.password =password;
        return this;
    }
}
