package info.gaofei.rabbitmq.mq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

/**
 * Created by GaoQingming on 2018/10/17 0017.
 */
@Component("cConsumer")
public class CConsumer implements MessageListener {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void onMessage(Message message) {
        try {
            byte[] body = message.getBody();
            String result = new String(body,0,body.length,"utf-8");
            logger.info("c consumer got message:{}", result);
        } catch (Exception e) {

        }
    }
}
