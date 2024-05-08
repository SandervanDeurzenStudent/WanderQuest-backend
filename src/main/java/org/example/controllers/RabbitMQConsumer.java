//
//import com.rabbitmq.client.*;
//
//
//public class RabbitMQConsumer {
//
//    private final static String QUEUE_NAME = "hello";
//
//    public static void main(String[] args) throws Exception {
//        // Verbinding maken met de RabbitMQ-server
//        ConnectionFactory factory = new ConnectionFactory();
//        factory.setHost("localhost"); // Hostnaam van de RabbitMQ-server
//
//        try (Connection connection = factory.newConnection();
//             Channel channel = connection.createChannel()) {
//
//            // Declareren van de queue
//            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
//            System.out.println(" [*] Wachten op berichten. Druk op CTRL+C om te stoppen");
//
//            // Berichten consumeren van de queue
//            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
//                String message = new String(delivery.getBody(), "UTF-8");
//                System.out.println(" [x] Bericht ontvangen: '" + message + "'");
//            };
//
//            channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
//        }
//    }
//}
//
