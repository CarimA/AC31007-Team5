/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stores;
import java.util.UUID;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Aleksandr
 */
public class Student {
    UUID id;
    String firstname;
    String lastname;
    int age;
    String module;
    String preference;
    
    public Student()
    {
        
    }
    public Student(UUID id, String firstname, String lastname, int age, String module, String preference)
    {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname; 
        this.age = age;
        this.module = module;
        this.preference = preference;
    }
    
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
    
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

}
