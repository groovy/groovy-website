class Library extends LinkedHashMap<String, Book> {
    void book(String title, Closure bookClosure) {
        def book = new Book(title: title)
        def clone = bookClosure.rehydrate(book, book, book)
        clone()
        put(title, book)
    }
}
