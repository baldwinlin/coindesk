package com.example.coindesk.model;

import jakarta.persistence.*;

@Entity
@Table(name="coins")
public class Coins {

    @Id
    @Column(name = "name")
    String name;

    @Column(name = "chtname")
    String chtname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChtname() {
        return chtname;
    }

    public void setChtname(String chtname) {
        this.chtname = chtname;
    }
}
