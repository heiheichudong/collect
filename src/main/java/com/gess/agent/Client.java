package com.gess.agent;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        Subject user = new User();
        Subject subject = new SubjectProxy(user);
        subject.subject();

        Subject subject1 = ((Subject) new DynamicSubject().find(new User()));
        subject1.subject();
    }
}
