package com.iv.p404.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Customer {
    @Id
    private Integer id;
    private String name;
    @OneToMany
    private List<Book> bookList;
}
