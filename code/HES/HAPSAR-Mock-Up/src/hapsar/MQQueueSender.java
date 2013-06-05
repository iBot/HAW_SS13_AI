package hapsar;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: tobi
 * Date: 05.06.13
 * Time: 10:16
 * To change this template use File | Settings | File Templates.
 */
public class MQQueueSender{


    private ConnectionFactory factory;
    private Connection connection;
    private Channel channel;
    private final String QUEUE_NAME = "HAPSAR_test";

    MQQueueSender() throws IOException {
        factory = new ConnectionFactory();
        factory.setHost("localhost");
        connection = factory.newConnection();
        channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
    }


    public void sendMessage(String message) throws IOException {
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");
    }

    public void close() throws IOException {
        channel.close();
        connection.close();
    }


}
