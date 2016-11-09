package jpa.crud.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jpa.crud.entity.Address;
import jpa.crud.entity.Message;
import jpa.crud.entity.MessageID;
import jpa.crud.entity.MessageType;
import jpa.crud.entity.Person;

/**
 * @author szia
 *
 */

public class JpaMain {

	private SessionFactory sessionFactory;
	
	public static void main(String[] args) {
		JpaMain jpa = new JpaMain();
		try {
			jpa.buildSessionFactory();
//			Session session = jpa.sessionFactory.openSession();
			Session session = null;
//			session.beginTransaction();
//		
//			Message message = jpa.buildMessage();
//			session.save(message.getMessageType());
//			session.save(message);
//			session.getTransaction().commit();
//			session.close();
//			
//			message = null;
//			
//			session = jpa.sessionFactory.openSession();
//			session.beginTransaction();
//			Criteria criteria = session.createCriteria(Message.class);
//			criteria.add(Restrictions.eq("messageID.messageID", 1));
//			message = (Message)criteria.uniqueResult();
//			System.out.println("Message is " + message.getMessageType().getMessageText());
//			//session.update(message.getMessageType());
//			//session.saveOrUpdate(message);
//			session.getTransaction().commit();
//			
//			message = null;
//			System.out.println("Querying first message");
//			session = jpa.sessionFactory.openSession();
//			session.beginTransaction();
//			final MessageID id = new MessageID();
//			id.setMessageID(1);
//			id.setMessageTypeCD("ST");
//			Message msg1 = session.get(Message.class, id);
//			session.getTransaction().commit();
//			session.close();
//			
//			
//			session = jpa.sessionFactory.openSession();
//			session.beginTransaction();
//			System.out.println("Querying second message");
//			Message msg2 = session.get(Message.class, id);
//			msg2.setComment("Updated comment");
//			session.update(msg2);
//			//session.update(msg1);
//			msg2.setComment("another updated comment");
//			session.getTransaction().commit();
//			session.close();
//		
			Person person = jpa.buildPerson();
			session = jpa.openSessionAndTransaction();
			session.save(person);
			jpa.closeSessionAndCommit(session);
//			session = jpa.openSessionAndTransaction();
//			session.save(person);
//			jpa.closeSessionAndCommit(session);
			session = jpa.openSessionAndTransaction();
			Person p1 = person;
			p1.setName("Foo");
			session.save(p1);
			//session.merge(p1);
			//session.delete(person);
			jpa.closeSessionAndCommit(session);
		}
		finally {
			
			jpa.closeSessionFactory();
		}
	}
	
	private Session openSessionAndTransaction() {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		return session;
	}
	
	private void closeSessionAndCommit(Session session) {
		session.getTransaction().commit();
		session.close();
	}
		
	private Message buildMessage() {
		MessageID id = new MessageID();
		Message message = new Message();
		MessageType messageType = new MessageType();
		messageType.setMessageText("first message text");
		messageType.setMessageTypeCD("ST");
		id.setMessageTypeCD(messageType.getMessageTypeCD());
		id.setMessageID(1);
		message.setComment("some message comment");
		message.setMessageType(messageType);
		message.setMessageID(id);
		return message;
	}
	
	private Person buildPerson() {
		Person person = new Person();
		person.setName("first person");
		
		Address addr1 = new Address();
		Address addr2 = new Address();
		
		addr1.setCity("foo city");
		addr1.setStreet("foo street");
		addr1.setPerson(person);
		
		addr2.setCity("second city");
		addr2.setStreet("second street");
		addr2.setPerson(person);
		
		person.getAddresses().add(addr1);
		//person.getAddresses().add(addr2);
		return person;
		
	}
	
	private SessionFactory buildSessionFactory() {
		try {
			// load from different directory
			sessionFactory = new Configuration().configure(
					"hibernate.cfg.xml")
					.buildSessionFactory();

			return sessionFactory;

		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	private void closeSessionFactory() {
		sessionFactory.close();
	}
}


