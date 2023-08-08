package com.example.finalprojectbackend.lab2you.db.model;



import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Role {
    private String name;
    public Role(String name) {
        this.name = name;
    }
}
