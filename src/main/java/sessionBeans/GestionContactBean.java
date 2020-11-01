package sessionBeans;
import entityBeans.Contact;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class GestionContactBean
 */
@Stateless(mappedName="ContactBean")
public class GestionContactBean implements GestionContactRemote {
    @PersistenceContext
    EntityManager em;

    public void addContact(String fname, String lname, String email) {
        Contact contact = new Contact();
        contact.setFirstName(fname);
        contact.setLastName(lname);
        contact.setEmail(email);
        em.persist(contact);
    }

    public String findContactNameById(long id) {
        Contact contact=em.find(Contact.class, id);
        return contact.getLastName() +", "+contact.getFirstName();
    }

    public String coucouContact(String nomContact) {
        return "Coucou, "+nomContact;
    }
}