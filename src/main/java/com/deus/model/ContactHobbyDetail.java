package com.deus.model;

import javax.persistence.*;

@Entity
@Table(name = "contact_hobby_detail", schema = "jpa_hibernate_db")
@IdClass(ContactHobbyDetailPK.class)
public class ContactHobbyDetail {
    @Id
    @Column(name = "contact_id", nullable = false, insertable = false)
    private Integer contactId;
    @Id
    @Column(name = "hobby_id")
    private String hobbyId;
    @ManyToOne
    @JoinColumn(name = "contact_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Contact contactByContactId;

    public Contact getContactByContactId() {
        return contactByContactId;
    }

    public void setContactByContactId(Contact contactByContactId) {
        this.contactByContactId = contactByContactId;
    }
    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
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

        ContactHobbyDetail that = (ContactHobbyDetail) o;

        if (contactId != that.contactId) return false;
        if (hobbyId != null ? !hobbyId.equals(that.hobbyId) : that.hobbyId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = contactId;
        result = 31 * result + (hobbyId != null ? hobbyId.hashCode() : 0);
        return result;
    }
}
