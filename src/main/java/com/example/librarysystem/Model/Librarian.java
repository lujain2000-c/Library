package com.example.librarysystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Librarian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
    @NotEmpty(message= "should be not null")
    @Column(columnDefinition = "varchar(30) not null ")
    private String name;
    @NotEmpty(message= "should be not null")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String username;
    @NotEmpty(message= "should be not null")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$")
    @Column(columnDefinition = "varchar(30) not null ")
    private String password;  //(use pattren)
    @NotEmpty(message= "should be not null")
    @Email
    @Column(columnDefinition = "varchar(30) not null unique")
    private String email; // (valid email) (check unique)
}
