package snowy_tales.tasks;

import snowy_tales.App;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.QueueingConsumer;
/**
 * Worker node to rabbitmq
 * @author dorisip
 *
 */
public class Worker {

	private final static String QUEUE_NAME = "pdf";
	private final static String HOST = "localhost";
	private final static Boolean DURABLE = true;
	private final static Boolean EXCLUSIVE = false;
	private final static Boolean AUTO_DELETE = false;
	private final static Boolean AUTO_ACK = false;
	private final static Boolean MULTIPLE_ACK = false;
	// One task at a time per worker
	private final static int PREFETCH_COUNT = 1;

	public static void main(String[] argv) throws java.io.IOException,
			java.lang.InterruptedException {

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(HOST);
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.queueDeclare(QUEUE_NAME, DURABLE, EXCLUSIVE, AUTO_DELETE, null);
		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
		
		channel.basicQos(PREFETCH_COUNT);

		QueueingConsumer consumer = new QueueingConsumer(channel);
		channel.basicConsume(QUEUE_NAME, AUTO_ACK, consumer);

		while (true) {
			// Blocks until next message is received
			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
			String message = new String(delivery.getBody());
			System.out.println(" [x] Received '" + message + "'");
			// Call generate PDF
			// Right now message is the file name
			App.createPdf(message);
			
			channel.basicAck(delivery.getEnvelope().getDeliveryTag(), MULTIPLE_ACK);
		}
	}

}
