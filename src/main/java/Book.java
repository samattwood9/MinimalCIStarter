import java.util.Objects;

public class Book {
    private String title;
    private double price;

    // constructor
    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    // getters + setters
    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    // overrides
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(price, book.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price);
    }
}
