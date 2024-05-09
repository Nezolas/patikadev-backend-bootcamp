package project.com.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;

    @ManyToMany (mappedBy = "categoryList", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private java.util.List<Book> bookList;

}
