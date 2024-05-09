package project.com.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int publicationYear;
    private int stock;


    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "publisher_id", referencedColumnName = "id")
    private Publisher publisher;

    @OneToMany (mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private java.util.List<BookBorrowing> bookBorrowingList;

    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable(
            name = "book_category",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private java.util.List<Category> categoryList;
}
