package com.example.design.prototype.framework;

public interface ProductPrototype extends Cloneable {
    public abstract void use(String s);
    public abstract ProductPrototype createClone();
}
