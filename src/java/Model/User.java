/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author RAO
 */
public class User {
    private String id;
    private String Password;
    private String name;
    private String type;
    private String dob;
    private String Address;
public User()
{
    
}
    public User(String id, String password,String name, String type, String dob, String Address) {
        this.id = id;
        this.Password=password;
        this.name = name;
        this.type = type;
        this.dob = dob;
        this.Address = Address;
    }

    public String getPassword() {
        return Password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDob() {
        return dob;
    }

    public String getAddress() {
        return Address;
    }
    
}
