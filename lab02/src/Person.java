// Renan Neves de Oliveira 257364

import java.util.Scanner;

public abstract class Person{
    //Adicionar os atributos da classe Person
    public String name;
    public String email;
    public String phone;

    // Métodos a serem implementados da classe Person
    public abstract void register(Scanner input);
    public abstract void update(String field, String newValue);
    
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}