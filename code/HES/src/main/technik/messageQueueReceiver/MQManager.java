package main.technik.messageQueueReceiver;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created with IntelliJ IDEA.
 * User: tobi
 * Date: 05.06.13
 * Time: 14:38
 * To change this template use File | Settings | File Templates.
 */
public class MQManager implements IMQManager {
    private final static String QUEUE_NAME = "HAPSAR";
    private final ConcurrentLinkedQueue<IZahlungseingangMessage> messages;
    private ConnectionFactory factory;
    private Connection connection;
    private Channel channel;
    private QueueingConsumer consumer;
    private boolean receive;
    private Runnable receiverThread;
    private List<INewMessageListener> messageListener = new ArrayList<>();

    public MQManager() {
        this.messages = new ConcurrentLinkedQueue<>();
        try {
            factory = new ConnectionFactory();
            factory.setHost("localhost");
            connection = factory.newConnection();
            channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);
            receive = false;
        } catch (IOException e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            System.out.println("MessageQueueReader konnte nicht erstellt werden. " + e);
        }
    }

    private boolean isReceive() {
        return receive;
    }

    @Override
    public void start() {
        receive = true;
        consumer = new QueueingConsumer(channel);
        final QueueingConsumer c = consumer;
        try {
            channel.basicConsume(QUEUE_NAME, true, consumer);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        receiverThread = new Runnable() {
            @Override
            public void run() {
                while (isReceive()) {
                    QueueingConsumer.Delivery delivery = null;
                    try {
                        delivery = c.nextDelivery();
                    } catch (InterruptedException e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }
                    String message = new String(delivery.getBody());
                    messages.add(new ZahlungseingangMessage(message));
                    System.out.printf(" Received '%s'%n", message);
                }
            }
        };
        receiverThread.run();
    }

    @Override
    public void stop() {
        receive = false;
        try {
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    @Override
    public IZahlungseingangMessage getNextMessage() {
        return messages.peek();
    }

    @Override
    public void subscribeForMessages(INewMessageListener listener) {
        if (!messageListener.contains(listener)) {
            messageListener.add(listener);
        }
    }

}
