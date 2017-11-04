//package mdb;
//
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//import javax.ejb.ActivationConfigProperty;
//import javax.ejb.MessageDriven;
//import javax.jms.Message;
//import javax.jms.MessageListener;
//import javax.jms.TextMessage;
//
///**
// * Message-Driven Bean implementation class for: MDBExample
// */
//@MessageDriven(
//		activationConfig = { @ActivationConfigProperty(
//				propertyName = "destination", propertyValue = "java:/jms/queue/ColaOfertaHoteles"), @ActivationConfigProperty(
//				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
//		}, 
//		mappedName = "java:/jms/queue/ColaOfertaHoteles")
//public class MDB implements MessageListener {
//
//    /**
//     * Default constructor. 
//     */
//    public MDB() {
//    }
//	
//	/**
//     * @see MessageListener#onMessage(Message)
//     */
//    public void onMessage(Message message) {
//    	  try {
//              String messageText = null;
//              if(message instanceof TextMessage){
//                  messageText = ((TextMessage)message).getText();
//              }
//              Logger.getAnonymousLogger().info("Mensaje recibido: " + messageText);
//          } catch (Exception e) {
//              Logger.getAnonymousLogger().log(Level.SEVERE, e.getMessage(), e);
//          }
//    }
//
//}
