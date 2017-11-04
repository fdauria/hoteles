package mdb;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.TextMessage;

@Stateless
public class Producer {

	@Resource(lookup = "java:/jms/queue/ColaOfertaHoteles")
	private Queue ColaOfertaHoteles;

	@Inject
	@JMSConnectionFactory("java:/ConnectionFactory")
	JMSContext context;

	public void sendMessage(String messageText) {
		TextMessage message = context.createTextMessage(messageText);
		context.createProducer().send(ColaOfertaHoteles, message);
	}
}
