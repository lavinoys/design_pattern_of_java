package com.example.design.abstract_factory.listfactory;

import com.example.design.abstract_factory.factory.AbstractFactory;
import com.example.design.abstract_factory.factory.Link;
import com.example.design.abstract_factory.factory.Page;
import com.example.design.abstract_factory.factory.Tray;

public class ListFactory extends AbstractFactory {
    @Override
    public Link createLink(String caption, String url) {
        return new ListLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new ListPage(title, author);
    }
}
