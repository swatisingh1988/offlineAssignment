package com.amdocs.offline.assesment.mockcomment.entity;

import com.amdocs.offline.assesment.mockcomment.service.ICommentOperations;

public class ValidUser implements ICommentOperations {
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
