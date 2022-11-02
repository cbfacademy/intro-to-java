public class BookShopTest {
    public static void Test() {
        Author author1 = new Author("Yaa Gyasi", "New York", 1234567);
        Author author2 = new Author("Akala", "London", 442034567);
        Author author3 = new Author("Edward Enninful", "London", 442085555);
        Author author4 = new Author("Robert Cecil Martin", "San Francisco", 14059654);
        Book[] books = new Book[] {
                new Book(author1, "Homegoing"),
                new Book(author1, "No Home"),
                new Book(author2, "Natives"),
                new Magazine(author3, "British Vogue"),
                new Textbook(author4, "Clean Code")
        };

        for (Book book: books) {
            System.out.println(book);
        }
    }
}
