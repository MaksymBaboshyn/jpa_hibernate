package com.deus.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "hobby", schema = "jpa_hibernate_db")
public class Hobby {
    @Id
    @Column(name = "hobby_id")
    private String hobbyId;
    @ManyToMany
    @JoinTable(name = "contact_hobby_detail",
            //foreign key for HobbyEntity in contact_hobby_detail table
            joinColumns = @JoinColumn(name = "hobby_id"),
            //key for other side - contact table
            inverseJoinColumns = @JoinColumn(name = "contact_id"))
    private Set<Contact> contacts = new HashSet<Contact>();

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    public String getHobbyId() {
        return hobbyId;
    }

    public void setHobbyId(String hobbyId) {
        this.hobbyId = hobbyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hobby that = (Hobby) o;

        if (hobbyId != null ? !hobbyId.equals(that.hobbyId) : that.hobbyId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return hobbyId != null ? hobbyId.hashCode() : 0;
    }
}
