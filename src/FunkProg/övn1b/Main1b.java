package FunkProg.övn1b;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class Main1b {
    List<Book> books = BookUtil.getBookList();

    Searchable title = (b,s)->b.getTitle().equalsIgnoreCase(s);
    Searchable owner = (b,s)->b.getOwner().getName().equalsIgnoreCase(s);
    Searchable author = (b,s)->b.getAuthor().equalsIgnoreCase(s);
    Searchable color = (b,s)->b.getColor().equalsIgnoreCase(s);
    Searchable genre = (b,s)->b.getGenre().equalsIgnoreCase(s);
    public void searchBooks(String key, Searchable sai){
        books.stream().filter(b -> sai.search(b,key))
                .map(Book::getTitle).forEach(b -> System.out.println(b));
    }

    public Main1b(){

        Scanner sc = new Scanner(System.in);
        System.out.println("typ?");
        String typ = sc.nextLine().trim();
        System.out.println("vad?");
        String vad = sc.nextLine().trim();

        switch (typ.toLowerCase()){
            case "title"->searchBooks(vad,title);
            case "owner"->searchBooks(vad,owner);
            case "author"->searchBooks(vad,author);
            case "color"->searchBooks(vad,color);
            case "genre"->searchBooks(vad,genre);
            default -> System.out.println("oops");
        }



/*
        List myTitles = books.stream().filter(b -> b.getOwner().equalsIgnoreCase("anna"))
                .map(Book::getTitle).toList();
        System.out.println(myTitles);
        books.stream().filter(b -> b.getOwner().equalsIgnoreCase("anna"))
                .map(Book::getTitle).forEach(b -> System.out.println(b));

        Map<String,Integer> result = new HashMap<>();
        books.stream().forEach(book -> result.putIfAbsent(book.getOwner(),(result.get(book.getRating()))));
        result.forEach((k,v)-> System.out.println(k+": "+v));

        Map<String, List<Book>> map= books.stream().collect(groupingBy(b->b.getOwner()));
        map.forEach((k,v)-> System.out.println(k+" "+v));

        System.out.println(map.get("Anna").stream().mapToInt(book -> book.getRating()).sum());
        map.forEach((k,v)-> System.out.println(k +": "+map.get(k).stream().
                mapToInt(book -> book.getRating()).sum()));


 */

    }

    public static void main(String[] args) {
        Main1b b = new Main1b();
    }
}
