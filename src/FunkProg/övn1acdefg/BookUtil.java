package FunkProg.övn1acdefg;

import java.util.Arrays;
import java.util.List;

public class BookUtil {

    public static List<Book> getBookList() {
        Book b1 = new Book("Good night Mr Tom", "Michelle Magorian", "green",
                Genre.FRIENDSHIP, 5, "Anna", false);
        Book b2 = new Book("A little love song", "Michelle Magorian", "blue",
                Genre.ROMANCE, 4, "Anna", false);
        Book b3 = new Book("Game of Thrones", "George R.R. Martin", "black",
                Genre.FANTASY, 3, "Mats", false);
        Book b4 = new Book("Pet Sematary", "Stephen King", "black",
                Genre.HORROR, 3, "Lena", false);
        Book b5 = new Book("The Hobbit", "J.R.R Tolkien", "white",
                Genre.FANTASY, 4, "Mats", false);
        Book b6 = new Book("Zebraflickan", "Sofia Åkerström", "black",
                Genre.AUTOBIOGRAPHY, 4, "Anna", true);
        Book b7 = new Book("Return of the King", "J.R.R Tolkien", "blue",
                Genre.FANTASY, 4, "Lena", false);
        Book b8 = new Book("MLK: an American Legacy", "David J. Garrow", "black",
                Genre.HISTORY, 5, "Anna", true);


        return Arrays.asList(b1, b2, b3, b4, b5, b6, b7, b8);


    }

    public static List<List<Book>> getBookListC() {
        Book b1 = new Book("Good night Mr Tom", "Michelle Magorian", "green",
                Genre.FRIENDSHIP, 5, "Anna", false);
        Book b2 = new Book("A little love song", "Michelle Magorian", "blue",
                Genre.ROMANCE, 4, "Anna", false);
        Book b3 = new Book("Game of Thrones", "George R.R. Martin", "black",
                Genre.FANTASY, 3, "Mats", false);
        Book b4 = new Book("Pet Sematary", "Stephen King", "black",
                Genre.HORROR, 3, "Lena", false);
        Book b5 = new Book("The Hobbit", "J.R.R Tolkien", "white",
                Genre.FANTASY, 4, "Mats", false);
        Book b6 = new Book("Zebraflickan", "Sofia Åkerström", "black",
                Genre.AUTOBIOGRAPHY, 4, "Anna", true);
        Book b7 = new Book("Return of the King", "J.R.R Tolkien", "blue",
                Genre.FANTASY, 4, "Lena", false);
        Book b8 = new Book("MLK: an American Legacy", "David J. Garrow", "black",
                Genre.HISTORY, 5, "Anna", true);


        List<Book> l1 = Arrays.asList(b1,b2);
        List<Book> l2 = Arrays.asList(b3,b5,b7);
        List<Book> l3 = Arrays.asList(b4,b6,b8);

        return Arrays.asList(l1,l2,l3);

    }

}
