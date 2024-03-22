import java.util.Comparator;

public class PageOrderComp extends Book implements Comparator {
    public PageOrderComp(String bookName, int printLength, String authorName, String publicationSeason, int publicationYear) {
        super(bookName, printLength, authorName, publicationSeason, publicationYear);
    }
    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
