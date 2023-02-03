package FunkProg.övn1acdefg;

import java.text.Collator;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main1acdefg {

    public Main1acdefg(){

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

        System.out.println("--------------------------------C--------------------");

        //uppg 1c
        List<List<Book>> cList = BookUtil.getBookListC();
        cList.stream().flatMap(list -> list.stream()).forEach(list-> System.out.println(list));
        cList.stream().flatMap(l->l.stream().map(Book::getTitle)).forEach(l-> System.out.println(l));

        System.out.println("--------------------------------D--------------------");
        //1d
        System.out.println(books.stream().map(Book::getRating).reduce(0, (rateSum,b)->rateSum+b));
        System.out.println(books.stream().map(Book::getRating).reduce(0, Integer::sum));
        System.out.println(books.stream().map(Book::getTitle).reduce("", (str,title)->str+title+", "));

        System.out.println("--------------------------------E--------------------");
        //1e
        System.out.println(books.stream().mapToInt(Book::getRating).average().orElse(0));
        System.out.println(books.stream().filter(b->b.getOwner().equalsIgnoreCase("anna")
                &&b.getColor().equalsIgnoreCase("black")));
        System.out.println(books.stream().anyMatch(b->b.getAuthor().equalsIgnoreCase("Michelle Magorian")));

        System.out.println("--------------------------------F--------------------");
        //1f
        List rated = books.stream().sorted(Comparator.comparing(a -> ((Integer) a.getRating()))).toList();
        //Collator c = Collator.getInstance(new Locale("sv","SE"));
        //books.stream().map(Book::getTitle).sorted(c).forEach(System.out::println);
        rated.stream().forEach(System.out::println);
        System.out.println("--------------------------------G--------------------");

        //1g
        System.out.println(books.stream().map(Book::getTitle).collect(Collectors.joining(", ")));


        List<Book> tiny = books.stream().filter(b->b.isFact()).toList();

        tiny.stream().map(b-> tiny.indexOf(b) + ". " + b.getTitle()).forEach(System.out::println);

        System.out.println("--------------------------------HASHMAP--------------------");
        var counter = new AtomicInteger(1);
        var orderedMap = new LinkedHashMap<Integer,String>();

        books.stream().map(Book::getTitle).forEachOrdered(string -> orderedMap.put(counter.getAndIncrement(),string));
        orderedMap.forEach((number, string) -> System.out.println(number + ". " + string));

        System.out.println();

        AtomicInteger count = new AtomicInteger(1);
        var orderedMap2 = new LinkedHashMap<Integer, Book>();

        books.stream().filter(b->b.getOwner().equalsIgnoreCase("anna")).forEachOrdered(bok -> orderedMap2.put(count.getAndIncrement(),bok));
        orderedMap2.forEach((num,bok)-> System.out.println(num + ". " + bok.toString()));

        int i = 2;

    }

    public static void main(String[] args) {
        Main1acdefg a = new Main1acdefg();
    }
}
