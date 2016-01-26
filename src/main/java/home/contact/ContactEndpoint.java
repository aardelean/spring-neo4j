package home.contact;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping(path = "/contacts")
public class ContactEndpoint {

    private static final Logger logger = LoggerFactory.getLogger(ContactEndpoint.class);

    @Autowired
    private ContactRepository repository;

    @RequestMapping(path = "/{id}",  method = RequestMethod.GET, produces = "application/json")
    public ContactTransport getById(@PathVariable("id") Long id){
        return ContactTransport.transform(repository.findOne(id));
    }

    @RequestMapping(path = "/check",  method = RequestMethod.GET, produces = "application/json")
    public String check(){
        return "ok!";
    }


    @PostConstruct
    public void setup(){
//        Contact contact = new Contact(1l, "Alex A");
//        contact
//                .friendWith(new Contact("Bogdan B"))
//                .friendWith(new Contact("Cristi C"));
//        repository.save(contact);
    }
}
