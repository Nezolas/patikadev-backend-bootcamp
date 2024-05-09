package project.com.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class BookBorrowing {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;
    private String borrowerName;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    @ManyToOne()
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToMany (mappedBy = "categoryList", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)

    private java.util.List<Book> bookList;

}
