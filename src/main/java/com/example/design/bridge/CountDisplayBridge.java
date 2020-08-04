package com.example.design.bridge;

public class CountDisplayBridge extends DisplayBridge {
    public CountDisplayBridge(DisplayImplBridge impl) {
        super(impl);
    }

    public void multiDisplay(int times) {
        open();
        for (int i = 0; i < times; i++) {
            print();
        }
        close();
    }
}
