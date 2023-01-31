package FunkProg.övn1acdefg;

public class Book {
    private String title;
    private String author;
    private String color;
    private Genre genre;
    private int rating;
    private String Owner;
    private boolean fact;

    public Book(String title, String author, String color, Genre genre, int rating, String owner, boolean fact) {
        this.title = title;
        this.author = author;
        this.color = color;
        this.genre = genre;
        this.rating = rating;
        Owner = owner;
        this.fact = fact;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public boolean isFact() {
        return fact;
    }

    public void setFact(boolean fact) {
        this.fact = fact;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", color='" + color + '\'' +
                ", genre=" + genre +
                ", rating=" + rating +
                ", Owner='" + Owner + '\'' +
                ", fact=" + fact +
                '}';
    }
}
