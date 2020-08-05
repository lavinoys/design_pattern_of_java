package com.example.design;

import com.example.design.abstract_factory.factory.AbstractFactory;
import com.example.design.abstract_factory.factory.Link;
import com.example.design.abstract_factory.factory.Page;
import com.example.design.abstract_factory.factory.Tray;
import com.example.design.adapter.Print;
import com.example.design.adapter.PrintBanner;
import com.example.design.bridge.CountDisplayBridge;
import com.example.design.bridge.DisplayBridge;
import com.example.design.bridge.StringDisplayImplBridge;
import com.example.design.builder.Director;
import com.example.design.builder.HTMLBuilder;
import com.example.design.builder.TextBuilder;
import com.example.design.factory.framework.Factory;
import com.example.design.factory.framework.Product;
import com.example.design.factory.idcard.IDCardFactory;
import com.example.design.iterator.Book;
import com.example.design.iterator.BookShelf;
import com.example.design.iterator.Iterator;
import com.example.design.prototype.MessageBox;
import com.example.design.prototype.UnderlinePen;
import com.example.design.prototype.framework.Manager;
import com.example.design.prototype.framework.ProductPrototype;
import com.example.design.singleton.Singleton;
import com.example.design.strategy.HandStrategy;
import com.example.design.strategy.PlayerStrategy;
import com.example.design.strategy.ProbStrategy;
import com.example.design.strategy.WinningStrategy;
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

    @Test
    @DisplayName("Factory Method Pattern")
    void factoryMethodTest() {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("홍길동");
        Product card2 = factory.create("이순신");
        Product card3 = factory.create("강감찬");
        card1.use();
        card2.use();
        card3.use();
    }

    @Test
    @DisplayName("Singleton Pattern")
    void singletonTest() {
        System.out.println("Start.");
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();

        if(obj1 == obj2) {
            System.out.println("obj1과 obj2는 같은 인스턴스 입니다.");
        } else {
            System.out.println("obj1과 obj2는 다른 인스턴스 입니다.");
        }
        System.out.println("End.");
    }

    @Test
    @DisplayName("Prototype Pattern")
    void prototypeTest() {
        Manager manager = new Manager();
        UnderlinePen upen = new UnderlinePen('~');
        MessageBox mbox = new MessageBox('*');
        MessageBox sbox = new MessageBox('/');
        manager.register("strong message", upen);
        manager.register("warning box", mbox);
        manager.register("slash box", sbox);

        ProductPrototype p1 = manager.create("strong message");
        p1.use("Hello, world.");
        ProductPrototype p2 = manager.create("warning box");
        p2.use("Hello, world.");
        ProductPrototype p3 = manager.create("slash box");
        p3.use("Hello, world.");
    }

    @Test
    @DisplayName("Builder Pattern")
    void builderTextTest() {
        TextBuilder textBuilder = new TextBuilder();
        Director director = new Director(textBuilder);
        director.construct();
        String result = textBuilder.getResult();
        System.out.println(result);
    }

    @Test
    @DisplayName("Builder Pattern")
    void builderHtmlTest() {
        HTMLBuilder htmlBuilder = new HTMLBuilder();
        Director director = new Director(htmlBuilder);
        director.construct();
        String filename = htmlBuilder.getResult();
        System.out.println(filename + "가 작성되었습니다.");
    }

    @Test
    @DisplayName("Abstract Factory Pattern")
    void abstractFactoryTest() {
//        String template = "com.example.design.abstract_factory.listfactory.ListFactory";
        String factoryName = "com.example.design.abstract_factory.tablefactory.TableFactory";
        AbstractFactory factory = AbstractFactory.getFactory(factoryName);

        Link joins = factory.createLink("중앙일보", "http://www.joins.com/");
        Link chosun = factory.createLink("조선일보", "http://www.chosun.com/");

        Link us_yahoo = factory.createLink("Yahoo!", "http://www.yahoo.com/");
        Link kr_yahoo = factory.createLink("Yahoo!Korea", "http://www.yahoo.co.kr/");
        Link excite = factory.createLink("Excite", "http://www.excite.com/");
        Link google = factory.createLink("Google", "http://www.google.com/");

        Tray trayNews = factory.createTray("신문");
        trayNews.add(joins);
        trayNews.add(chosun);

        Tray trayYahoo = factory.createTray("Yahoo!");
        trayYahoo.add(us_yahoo);
        trayYahoo.add(kr_yahoo);

        Tray traySearch = factory.createTray("검색엔진");
        traySearch.add(trayYahoo);
        traySearch.add(excite);
        traySearch.add(google);

        Page page = factory.createPage("LinkPage", "영진닷컴");
        page.add(trayNews);
        page.add(traySearch);
        page.output();
    }
    @Test
    @DisplayName("Bridge Pattern")
    void bridgeTest() {
        DisplayBridge d1 = new DisplayBridge(new StringDisplayImplBridge("Hello, Korea."));
        DisplayBridge d2 = new CountDisplayBridge(new StringDisplayImplBridge("Hello, World."));
        CountDisplayBridge d3 = new CountDisplayBridge(new StringDisplayImplBridge("Hello, Universe."));

        d1.dispay();
        d2.dispay();
        d3.dispay();
        d3.multiDisplay(5);
    }

    @Test
    @DisplayName("Strategy Pattern")
    void StrategyTest() {

        int seed1 = 314;
        int seed2 = 15;

        PlayerStrategy player1 = new PlayerStrategy("두리", new WinningStrategy(seed1));
        PlayerStrategy player2 = new PlayerStrategy("하나", new ProbStrategy(seed2));

        for (int i = 0; i < 10000; i++) {
            HandStrategy nextHand1 = player1.nextHand();
            HandStrategy nextHand2 = player2.nextHand();

            if (nextHand1.isStrongerThan(nextHand2)) {
                System.out.println("Winner:" + player1);
                player1.win();
                player2.lose();
            } else if (nextHand2.isStrongerThan(nextHand1)) {
                System.out.println("Winner:" + player2);
                player1.lose();
                player2.win();
            } else {
                System.out.println("Even...");
                player1.even();
                player2.even();
            }
        }

        System.out.println("Total result:");
        System.out.println(player1.toString());
        System.out.println(player2.toString());
    }
}
