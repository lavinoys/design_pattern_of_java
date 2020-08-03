package com.example.design.abstract_factory.listfactory;

import com.example.design.abstract_factory.factory.Link;

public class ListLink extends Link {
    public ListLink(String cation, String url) {
        super(cation, url);
    }
    @Override
    public String makeHTML() {
        return "<li><a href=\"" + url + "\">" + caption + "</a></li>\n";
    }
}
