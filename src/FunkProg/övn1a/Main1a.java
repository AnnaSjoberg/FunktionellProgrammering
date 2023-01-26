package FunkProg.övn1a;

import java.util.List;

public class Main1a {

    public Main1a (){

        List<Book> books = BookUtil.getBookList();

        //alla av en viss författare
        books.stream().filter(b -> b.getAuthor().equalsIgnoreCase("michelle magorian")).forEach(b -> System.out.println(b));
        books.stream().filter(b -> b.getAuthor().contains("Tolkien")).forEach(b -> System.out.println(b));
        //alla av viss färg
        books.stream().filter(b -> b.getColor().equalsIgnoreCase("blue")||
                b.getColor().equalsIgnoreCase("black"))
                .forEach(b -> System.out.println(b.getColor() +": "+b.getTitle()));
        //räknar alla böcker som tillhör mig
        System.out.println(books.stream().filter(b -> b.getOwner().equalsIgnoreCase("Anna")).count());

    }

    public static void main(String[] args) {
        Main1a a = new Main1a();
    }
}
