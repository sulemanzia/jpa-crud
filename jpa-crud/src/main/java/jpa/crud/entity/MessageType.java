package jpa.crud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author szia
 *
 */
@Entity
@Table(name="message_type")
public class MessageType {

	@Id
	@Column(name="message_type_cd")
	private String messageTypeCD;
	
	@Column(name="message_text")
	private String messageText;
	
	public String getMessageTypeCD() {
		return messageTypeCD;
	}
	public void setMessageTypeCD(String messageTypeCD) {
		this.messageTypeCD = messageTypeCD;
	}
	public String getMessageText() {
		return messageText;
	}
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	
}


