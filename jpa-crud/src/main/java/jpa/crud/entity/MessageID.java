package jpa.crud.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * @author szia
 *
 */

@Embeddable
public class MessageID implements Serializable{

	@Column(name="message_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer messageID;
	@Column(name="message_type_cd")
	private String messageTypeCD;
	
	public Integer getMessageID() {
		return messageID;
	}
	public void setMessageID(Integer messageID) {
		this.messageID = messageID;
	}
	public String getMessageTypeCD() {
		return messageTypeCD;
	}
	public void setMessageTypeCD(String messageTypeCD) {
		this.messageTypeCD = messageTypeCD;
	}
	
	
}


