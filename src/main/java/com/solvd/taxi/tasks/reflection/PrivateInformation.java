package com.solvd.taxi.tasks.reflection;

public class PrivateInformation {
    private String name;
    private String surname;
    private String username;
    private String password;
    private String secretInfo;

    public PrivateInformation(){
        this.name = "";
        this.surname = "";
        this.username = "";
        this.password = "";
        this.secretInfo = "meow";
    }

    public PrivateInformation(String name, String surname, String username, String password, String secretInfo) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.secretInfo = secretInfo;
    }

    private String tellSecret() {
        return "My name is " + this.name + " and this is my secret: '" + this.secretInfo + "' and yes, I am that stupid to store secret data in project, so I even created a special method to get it :)";
    }
}
