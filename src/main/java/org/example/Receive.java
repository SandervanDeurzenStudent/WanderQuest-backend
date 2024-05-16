package org.example;

import com.rabbitmq.client.*;

public class Receive {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception {
        // Verbinding maken met de RabbitMQ-server
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUri("amqp://localhost:8080"); // API URL voor de RabbitMQ-server

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            // Declareren van de queue
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            System.out.println("[*] Wachten op berichten. Druk op Ctrl+C om te stoppen.");

            // Berichten consumeren
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                System.out.println("[x] Bericht ontvangen: '" + message + "'");
                // Hier kun je verdere verwerking van het bericht toevoegen

                // Bevestigen (ACK) dat het bericht is verwerkt
                channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
            };

            channel.basicConsume(QUEUE_NAME, false, deliverCallback, consumerTag -> { });
        }
    }
}
