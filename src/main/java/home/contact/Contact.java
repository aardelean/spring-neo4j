package home.contact;


import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class Contact implements Serializable{

    @GraphId
    private Long id;
    private String name;

    public Contact() {}
    public Contact(Long id, String name) {
        this.name = name;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Contact> getFriends() {
        return friends;
    }

    public void setFriends(Set<Contact> friends) {
        this.friends = friends;
    }

    public Contact(String name) {
        this.name = name;
    }

    @Relationship(type="FRIEND", direction = "")
    private Set<Contact> friends;

    public Contact friendWith(Contact person) {
        if (friends == null) {
            friends = new HashSet<>();
        }
        friends.add(person);
        return this;
    }

    public String toString() {
        String results = name + "'s friends include\n";
        if (friends != null) {
            for (Contact person : friends) {
                results += "\t- " + person.name + "\n";
            }
        }
        return results;
    }

}