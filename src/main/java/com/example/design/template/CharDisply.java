package com.example.design.template;

/**
 * CharDisply는 AbstractDisplay의 하위 클래스
 */
public class CharDisply extends AbstractDisplay {

    /**
     * 표시해야 할 문자
     */
    private char ch;

    /**
     * 생성자에서 전달된 문자 ch를 필드에 기억해 둔다.
     * @param ch 필드에 기억해 둔다.
     */
    public CharDisply(char ch) {
        this.ch = ch;
    }

    /**
     * 상위 클래스에서 추상 메소드였다.
     * 여기에서 오바라이드해서 구현한다.
     * 개시 문자열 "<<"을 표시한다.
     */
    @Override
    public void open() {
        System.out.print("<<");
    }


    /**
     * print 메소드도 여기에서 구현한다.
     * 이것이 display에서 반복해서 호출된다.
     * 필드에 기억해 둔 문자를 1개 표시한다.
     */
    @Override
    public void print() {
        System.out.print(ch);
    }

    /**
     * close 메소드도 여기에서 구현한다.
     * 종료 문자열 ">>"을 표시.
     */
    @Override
    public void close() {
        System.out.println(">>");
    }
}
