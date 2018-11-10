package com.sssr.others.dmd;

public class Dmd {

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        A r;

        r = a;
        System.out.print(r.getClass() + "\t");
        r.callme();

        r = b;
        System.out.print(r.getClass() + "\t");
        r.callme();

        r = c;
        System.out.print(r.getClass() + "\t");
        r.callme();
    }

}

class A {
    void callme() {
        System.out.println("Inside A's callme method");
    }
}

class B extends A {
    void callme() {
        System.out.println("Inside B's callme method");
    }
}

class C extends A {
    void callme() {
        System.out.println("Inside C's callme method");
    }
}