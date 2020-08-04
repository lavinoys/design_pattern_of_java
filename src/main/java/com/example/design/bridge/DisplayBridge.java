package com.example.design.bridge;


public class DisplayBridge {
    private DisplayImplBridge impl;

    public DisplayBridge(DisplayImplBridge impl) {
        this.impl = impl;
    }

    public void open() {
        impl.rawOpen();
    }

    public void print() {
        impl.rawPrint();
    }

    public void close() {
        impl.rawClose();
    }

    public final void dispay() {
        open();
        print();
        close();
    }
}
