package FunkProg.övn1b;

import java.util.List;

public class Main1b {

    public Main1b(){

        List<Book> books = BookUtil.getBookList();


//        books.stream().map(Book::getTitle).forEach(b-> System.out.println(b));
  //      books.stream().map(Book::getAuthor).distinct().forEach(b-> System.out.println(b));
        List myTitles = books.stream().filter(b -> b.getOwner().equalsIgnoreCase("anna"))
                .map(Book::getTitle).toList();
        System.out.println(myTitles);
        books.stream().filter(b -> b.getOwner().equalsIgnoreCase("anna"))
                .map(Book::getTitle).forEach(b -> System.out.println(b));
    }

    public static void main(String[] args) {
        Main1b b = new Main1b();
    }
}
