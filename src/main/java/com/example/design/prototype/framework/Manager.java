package com.example.design.prototype.framework;

import java.util.HashMap;

public class Manager {
    private HashMap showchase = new HashMap();
    public void register(String name, ProductPrototype proto) {
        showchase.put(name, proto);
    }
    public ProductPrototype create(String protoname) {
        ProductPrototype p = (ProductPrototype) showchase.get(protoname);
        return p.createClone();
    }

}
