package com.example.design.abstract_factory.factory;

public abstract class AbstractFactory {
    public static AbstractFactory getFactory(String classname) {
        AbstractFactory factory = null;
        try {
            factory = (AbstractFactory)Class.forName(classname).getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException e) {
            System.out.println("클래스" + classname + ". 이 발견되지 않습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return factory;
    }

    public abstract Link createLink(String caption, String url);
    public abstract Tray createTray(String caption);
    public abstract Page createPage(String title, String author);
}
