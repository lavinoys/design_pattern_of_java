package com.example.design;

import com.example.design.adapter.Print;
import com.example.design.adapter.PrintBanner;
import com.example.design.iterator.Book;
import com.example.design.iterator.BookShelf;
import com.example.design.iterator.Iterator;
import com.example.design.template.AbstractDisplay;
import com.example.design.template.CharDisply;
import com.example.design.template.StringDisplay;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class MainTest {

    @Test
    @DisplayName("Iterator Pattern")
    void iteratorTest() {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("Around the world in 80 Days"));
        bookShelf.appendBook(new Book("Bible"));
        bookShelf.appendBook(new Book("Cinderella"));
        bookShelf.appendBook(new Book("Daddy-Long-Legs"));
        Iterator it = bookShelf.iterator();
        while (it.hasNext()) {
            Book book = (Book) it.next();
            System.out.println(book.getName());
        }
    }

    @Test
    @DisplayName("Adapter Pattern")
    void adapterTest() {
        Print p = new PrintBanner("Hello");
        p.printWeak();
        p.printStrong();
    }

    @Test
    @DisplayName("Template Method Pattern")
    void templateMethodTest() {
        AbstractDisplay d1 = new CharDisply('H');
        AbstractDisplay d2 = new StringDisplay("Hello, world.");
        AbstractDisplay d3 = new StringDisplay("안녕하세요.");
        d1.display();
        d2.display();
        d3.display();
    }
}
