/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.*;
import java.lang.Object;
/**
 * @author ivan
 *
 */
public class Email {

	public MultiPartEmail email = new MultiPartEmail();

	public String workingDir;

	public Email(String path, String smtp) {
		this.email.setHostName(smtp);
		workingDir = path; // utile solo con gli allegati
	}

	public Email(String smtp) {
		this.email.setHostName(smtp);
		workingDir = ""; // utile solo con gli allegati
	}

	public Email _setPort(Object port) throws EmailException {
		this.email.setSmtpPort(Integer.valueOf(port.toString()));
		return this;
	}

	/**
	 * Set the FROM field of the email to use the specified address and the
	 * specified personal name.
	 *
	 * @param fAddr
	 * @param fName
	 * @return
	 * @throws EmailException
	 */
	public Email _from(Object fAddr, Object fName) throws EmailException {
		this.email.setFrom(fAddr.toString(), fName.toString());
		return this;
	}

	/**
	 * Set the FROM field of the email to use the specified address.
	 *
	 * @param fAddr
	 * @return
	 * @throws EmailException
	 */
	public Email _from(Object fAddr) throws EmailException {
		this.email.setFrom(fAddr.toString());
		return this;
	}

	/**
	 * Add a recipient TO to the email using the specified address and the
	 * specified personal name.
	 *
	 * @param tAddr
	 * @param tName
	 * @return
	 * @throws EmailException
	 */
	public Email _addTo(Object tAddr, Object tName) throws EmailException {
		this.email.addTo(tAddr.toString(), tName.toString());
		return this;
	}

	/**
	 * Add a recipient TO to the email.
	 *
	 * @param tAddr
	 * @return
	 * @throws EmailException
	 */
	public Email _addTo(Object tAddr) throws EmailException {
		this.email.addTo(tAddr.toString());
		return this;
	}

	/**
	 * Add a recipient CC to the email using the specified address and the
	 * specified personal name.
	 *
	 * @param tAddr
	 * @param tName
	 * @return
	 * @throws EmailException
	 */
	public Email _addCc(Object tAddr, Object tName) throws EmailException {
		this.email.addCc(tAddr.toString(), tName.toString());
		return this;
	}

	/**
	 * Add a recipient CC to the email.
	 *
	 * @param tAddr
	 * @return
	 * @throws EmailException
	 */
	public Email _addCc(Object tAddr) throws EmailException {
		this.email.addCc(tAddr.toString());
		return this;
	}

	/**
	 * Add a blind BCC recipient to the email using the specified address and
	 * the specified personal name.
	 *
	 * @param tAddr
	 * @param tName
	 * @return
	 * @throws EmailException
	 */
	public Email _addBcc(Object tAddr, Object tName) throws EmailException {
		this.email.addBcc(tAddr.toString(), tName.toString());
		return this;
	}

	/**
	 * Add a blind BCC recipient to the email.
	 *
	 * @param tAddr
	 * @return
	 * @throws EmailException
	 */
	public Email _addBcc(Object tAddr) throws EmailException {
		this.email.addBcc(tAddr.toString());
		return this;
	}

	/**
	 * Set the email subject.
	 *
	 * @param subject
	 * @return
	 * @throws EmailException
	 */
	public Email _subject(Object subject) throws EmailException {
		this.email.setSubject(subject.toString());
		return this;
	}

	/**
	 * Define the content of the mail.
	 *
	 * @param body
	 * @return
	 * @throws EmailException
	 */
	public Email _body(Object body) throws EmailException {
		this.email.setMsg(body.toString());
		return this;
	}

	/**
	 * Sends the email.
	 *
	 * @return
	 * @throws EmailException
	 */
	public Email _send() {
		try {
			this.email.send();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			// System.err.print(e.getMessage());
			//e.printStackTrace();
			throw new RuntimeException("Runtime Error: " + e.getMessage());
		}
		return this;
	}

	/**
	 * Sets the userName and password if authentication is needed.
	 *
	 * @param userName
	 * @param password
	 * @return
	 * @throws EmailException
	 */
	public Email _setAuth(Object userName, Object password)
			throws EmailException {
		this.email.setAuthentication(userName.toString(), password.toString());
		return this;
	}

        /**
	 * Sets the userName and password if authentication is needed.
	 *
	 * @param userName
	 * @param password
	 * @return
	 * @throws EmailException
	 */
	public Email _setTLS(boolean tlsBoolean)
			throws EmailException {
		this.email.setTLS(tlsBoolean);
		return this;
	}

	/**
	 *
	 * @param path
	 * @param name
	 * @param description
	 * @return
	 * @throws EmailException
	 */
	// bisogna importare anche : import org.apache.commons.io.FilenameUtils;

	/*public Email _addAttachment(Object path, Object name, Object description)
			throws EmailException {

		String pathString = FilenameUtils.concat(this.workingDir, path.toString());
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath(pathString);
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription(description.toString());
		attachment.setName(name.toString());

		this.email.attach(attachment);
		return this;
	}*/

	/**
	 *
	 * @param path
	 * @return
	 * @throws EmailException
	 */
	/*public Email _addAttachment(Object path) throws EmailException {

		String pathString = FilenameUtils.concat(this.workingDir, path.toString());
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath(pathString);
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		this.email.attach(attachment);
		return this;
	}*/

}

