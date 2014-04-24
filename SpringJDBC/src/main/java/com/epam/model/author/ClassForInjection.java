/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.model.author;
/*

 *
 * @author Anatolii_Hlazkov
 */
public class ClassForInjection {

    private String name;
    private String secondName;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return this.secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void printFullName() {
        System.out.println("My name is " + this.name + "   and second name is " + this.secondName);
    }

    @Override
    public String toString() {
        return "My name is " + this.name + "   and second name is " + this.secondName;
    }
}
