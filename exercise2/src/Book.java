public class Book {
    protected Author author;
    protected String title;
    protected float price;

    public Book(Author author, String title) {
        this.author = author;
        this.title = title;
        this.price = 10F;
    }

    public String getAuthorName(){
        return this.author.getName();
    }

    public String getTitle(){
        return this.title;
    }

    public float getPrice(){
        return this.price;
    }

    @Override
    public String toString() {
        return String.format("Title: %s, author: %s, price: £%.2f", this.title, this.getAuthorName(), this.price);
    }
}
