import java.time.LocalDate;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        book book1 = new book("The 100", "Kass Morgan", 2013, 8, 29);
        book book2 = new book("The Witcher", "Andrzej Sapkowski", 2007, 6, 7);
        book book3 = new book("Snowpiercer", "Jacques Lob", 1982, 9, 30);
        book book4 = new book("Outer Banks", "Alyssa Sheinmel", 2021, 12, 23);

        Set<book> booksSet = new HashSet<>();
        booksSet.add(book1);
        booksSet.add(book2);
        booksSet.add(book3);
        booksSet.add(book4);

        for(book theBook: booksSet) {
            if(theBook.getPublicationDate().getYear() <= 2010){
                System.out.println(theBook);
            }
        }
    }
}

class book {
    private String title;
    private String author;
    LocalDate publicationDate;


    public book(String title, String author, int yearOfPublication, int monthOfPublication, int dayOfPublication) {
        this.title = title;
        this.author = author;
        this.publicationDate = LocalDate.of(yearOfPublication, monthOfPublication, dayOfPublication);
    }

    public int hashCode(){
        return publicationDate.getYear() * 100 + publicationDate.getMonthValue();
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public boolean equals(Object o) {
        book e = (book) o;
        return (title.equals(e.getTitle())) &&
                (author.equals(e.getAuthor())) &&
                (publicationDate.getYear() == e.getPublicationDate().getYear()) &&
                (publicationDate.getMonthValue() == e.getPublicationDate().getMonthValue()) &&
                (publicationDate.getDayOfMonth() == e.getPublicationDate().getDayOfMonth());
    }

    public String toString() {
        return "title: " + title + ", " + "author: " + author + ", " + "date of publication: " + publicationDate;
    }
}