package am.jsl.personalfinances.service.contact;

import am.jsl.personalfinances.dao.contact.ContactDao;
import am.jsl.personalfinances.domain.Contact;
import am.jsl.personalfinances.ex.CannotDeleteException;
import am.jsl.personalfinances.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Wdrożenie usługi {@link ContactService}.
 */
@Service("contactService")
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class ContactServiceImpl extends BaseServiceImpl<Contact> implements ContactService {

    /**
     * Plik szablonu, w którym jest przechowywana reprezentacja html kontaktów.
     */
    private static final String CONTACT_LOOKUP_HTML = "contact-lookup.html";

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(long id, long userId) throws CannotDeleteException {
        super.delete(id, userId);
        publish(userId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void create(Contact contact) throws Exception {
        super.create(contact);
        publish(contact.getUserId());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(Contact contact) throws Exception {
        super.update(contact);
        publish(contact.getUserId());
    }

    /**
     * Generuje reprezentację html kontaktów dla danego identyfikatora użytkownika.
     * @param userId identyfikator użytkownika
     */
    private void publish(long userId) {
        if (!publishHtml) {
            log.info("Publish html is disabled");
            return;
        }

        List<Contact> contacts = lookup(userId);

        StringBuilder html = new StringBuilder();
        html.append("<option value='0'></option>");
        String name;

        for (Contact contact : contacts) {
            name = contact.getName();
            name = name == null ? "" : name;

            html.append("<option value='").append(contact.getId()).append("'>");
            html.append(name).append("</option>");
        }

        publish(userId, CONTACT_LOOKUP_HTML, html.toString());
    }

    /**
     * Setter dla właściwości 'contactDao'.
     *
     * @param contactDao Wartość do ustawienia dla właściwośći 'contactDao'.
     */
    @Autowired
    public void setContactDao(@Qualifier("contactDao") ContactDao contactDao) {
        setBaseDao(contactDao);
    }
}
