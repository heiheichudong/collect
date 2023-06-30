package com.gess.agent;

public class SubjectProxy implements Subject{

    private Subject subject;

    public SubjectProxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void subject() {
        this.subject.subject();
    }
}
