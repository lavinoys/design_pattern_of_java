package com.example.design.abstract_factory.tablefactory;

import com.example.design.abstract_factory.factory.AbstractFactory;
import com.example.design.abstract_factory.factory.Link;
import com.example.design.abstract_factory.factory.Page;
import com.example.design.abstract_factory.factory.Tray;

public class TableFactory extends AbstractFactory {
    @Override
    public Link createLink(String caption, String url) {
        return new TableLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return new TableTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new TablePage(title, author);
    }
}
