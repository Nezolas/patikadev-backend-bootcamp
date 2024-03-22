import java.util.TreeSet;

public class Main {
    public static void main(String[] args){
        TreeSet<Book> books = new TreeSet<>();
        books.add(new Book("Introduction to Algorithms ", 1292, "Thomas H Cormen, Charles E Leiserson, Ronald L Rivest, Clifford Stein", "September", 2009));
        books.add(new Book("Field and Wave Electromagnetics", 720, "David Cheng", "September", 2013));
        books.add(new Book("Electric Circuits 8th Edition", 855, " James W. Nilsson, Susan A. Riedel", "January", 2007));
        books.add(new Book("Thomas' Calculus, 11th Edition", 1228 , "George B. Thomas", "January", 2004));
        books.add(new Book("Schaum's Outline of Linear Algebra Fourth Edition", 432 , "Seymour Lipschutz, Marc Lipson", "August", 2008));
        System.out.println("*****************************************************************************************************************");
        for(Book bks : books){
            System.out.println(bks.getBookName()+"\t" +bks.getPrintLength()+"\t" + bks.getAuthorName()+"\t" + bks.getPublicationSeason()+"\t" + bks.getPublicationYear());
        }
        System.out.println("*****************************************************************************************************************");
        TreeSet<Book> pages = new TreeSet<>(new PageOrderComp(books));
        pages.add(new Book("Introduction to Algorithms", 1292, "Thomas H Cormen, Charles E Leiserson, Ronald L Rivest, Clifford Stein", "September", 2009));
        pages.add(new Book("Field and Wave Electromagnetics", 720, "David Cheng", "September", 2013));
        pages.add(new Book("Electric Circuits 8th Edition", 855, " James W. Nilsson, Susan A. Riedel", "January", 2007));
        pages.add(new Book("Thomas' Calculus, 11th Edition", 1228 , "George B. Thomas", "January", 2004));
        pages.add(new Book("Schaum's Outline of Linear Algebra Fourth Edition", 432 , "Seymour Lipschutz, Marc Lipson", "August", 2008));
        System.out.println("\n");
        for(Book pgs : pages){
            System.out.println(pgs.getBookName()+"\t" +pgs.getPrintLength()+"\t" + pgs.getAuthorName()+"\t" + pgs.getPublicationSeason()+"\t" + pgs.getPublicationYear());
        }
        System.out.println("*****************************************************************************************************************");
    }
}