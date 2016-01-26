package home.contact;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;

public class ContactTransport implements Serializable{

    private Long id;
    private String name;
    private Set<ContactTransport> friends;

    public ContactTransport(){}

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

    public Set<ContactTransport> getFriends() {
        return friends;
    }

    public void setFriends(Set<ContactTransport> friends) {
        this.friends = friends;
    }

    public ContactTransport(Contact contact){
        this.setId(contact.getId());
        this.setName(contact.getName());
    }

    public static ContactTransport transform(Contact contact){
        ContactTransport result = new ContactTransport(contact);
        result.setFriends(contact.getFriends().stream().map(p->new ContactTransport(p)).collect(Collectors.toSet()));
        return result;
    }
}
