package com.example.design.prototype;

import com.example.design.prototype.framework.ProductPrototype;

public class UnderlinePen implements ProductPrototype {

    private char ulchar;
    public UnderlinePen(char ulchar) {
        this.ulchar = ulchar;
    }

    @Override
    public void use(String s) {
        int length = s.getBytes().length;
        System.out.println("\"" + s + "\"");
        System.out.print("");
        for (int i = 0; i < length; i++) {
            System.out.print(ulchar);
        }
        System.out.println(ulchar);
    }

    @Override
    public ProductPrototype createClone() {
        ProductPrototype p = null;
        try {
            p = (ProductPrototype)clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
