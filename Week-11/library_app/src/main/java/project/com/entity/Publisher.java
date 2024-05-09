package project.com.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity

public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private String name;

    private Integer establishmentYear;

    private String address;


    @OneToMany (mappedBy = "publisher", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Book> bookList;
}
