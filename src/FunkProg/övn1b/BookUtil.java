package FunkProg.övn1b;

import java.util.Arrays;
import java.util.List;

public class BookUtil {


    public static List<Book> getBookList() {
        List<Person> owners = List.of(new Person("Anna","aa",36),
                new Person("Lena","ll",61),
                new Person("Mats","mm",62));



        Book b1 = new Book("Good night Mr Tom", "Michelle Magorian", "green",
                Genre.FRIENDSHIP, 5,owners.get(0) , false);
        Book b2 = new Book("A little love song", "Michelle Magorian", "blue",
                Genre.ROMANCE, 4, owners.get(0), false);
        Book b3 = new Book("Game of Thrones", "George R.R. Martin", "black",
                Genre.FANTASY, 3, owners.get(2), false);
        Book b4 = new Book("Pet Sematary", "Stephen King", "black",
                Genre.HORROR, 3, owners.get(1), false);
        Book b5 = new Book("The Hobbit", "J.R.R Tolkien", "white",
                Genre.FANTASY, 4, owners.get(2), false);
        Book b6 = new Book("Zebraflickan", "Sofia Åkerström", "black",
                Genre.AUTOBIOGRAPHY, 4, owners.get(0), true);
        Book b7 = new Book("Return of the King", "J.R.R Tolkien", "blue",
                Genre.FANTASY, 4, owners.get(1), false);
        Book b8 = new Book("MLK: an American Legacy", "David J. Garrow", "black",
                Genre.HISTORY, 5, owners.get(0), true);


        return Arrays.asList(b1, b2, b3, b4, b5, b6, b7, b8);


    }

}
