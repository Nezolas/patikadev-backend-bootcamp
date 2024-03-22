// Book class implementing Comparable interface
public class Book implements Comparable<Book>{
    private String bookName;
    private int printLength;
    private String authorName;
    private String publicationSeason;
    private int publicationYear;

    public String getBookName() {
        return bookName;
    }

    public int getPrintLength() {
        return printLength;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getPublicationSeason() {
        return publicationSeason;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setPrintLength(int printLength) {
        this.printLength = printLength;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setPublicationSeason(String publicationSeason) {
        this.publicationSeason = publicationSeason;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public Book(String bookName, int printLength, String authorName, String publicationSeason, int publicationYear) {
        this.bookName = bookName;
        this.printLength = printLength;
        this.authorName = authorName;
        this.publicationSeason = publicationSeason;
        this.publicationYear = publicationYear;
    }
    @Override
    public int compareTo(Book another) {
        return this.bookName.compareTo(another.bookName);
    }
  }
