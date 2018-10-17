package info.gaofei.rabbitmq.mq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

/**
 * 保存动态事件处理.
 */
@Component
public class OtherConsumer implements MessageListener {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void onMessage(Message message) {
        try {
            byte[] body = message.getBody();
            String result = new String(body,0,body.length,"utf-8");
            logger.info("other consumer got message:{}", result);
        } catch (Exception e) {

        }
    }
}
