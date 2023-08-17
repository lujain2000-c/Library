package com.example.librarysystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message= "should be not null")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String title;
    @NotEmpty(message= "should be not null")
    @Column(columnDefinition = "varchar(30) not null ")
    private String author;
    @NotEmpty(message= "should be not null")
    @Column(columnDefinition = "varchar(10) not null check(category = 'academic' || category = 'academic')")
    private String category;
    @NotNull(message= "should be not null")
    @Column(columnDefinition = "int(11) not null unique")
    private Integer ISBN;
    @NotNull(message= "should be not null")
    @Min(50)
    @Column(columnDefinition = "int(2000) not null check (numberOfPages >= 50 )")
    private Integer numberOfPages;
}
