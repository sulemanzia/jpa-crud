package jpa.crud.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author szia
 *
 */

@Entity
@Table(name="message")
public class Message {

	private String comment;
	@EmbeddedId
	private MessageID messageID;
	
	@ManyToOne
	@JoinColumn(name="message_type_cd",updatable=false,insertable=false)
	private MessageType messageType;
	
	public MessageID getMessageID() {
		return messageID;
	}
	public void setMessageID(MessageID messageID) {
		this.messageID = messageID;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public MessageType getMessageType() {
		return messageType;
	}
	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}
	
}


