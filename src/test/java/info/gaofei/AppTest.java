package info.gaofei;

import info.gaofei.rabbitmq.mq.GaofeiMqProducer;
import info.gaofei.rabbitmq.mq.consumer.AConsumer;
import info.gaofei.rabbitmq.mq.consumer.BConsumer;
import info.gaofei.rabbitmq.mq.consumer.CConsumer;
import info.gaofei.rabbitmq.mq.consumer.OtherConsumer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * Unit test for simple App.
 */
@ContextConfiguration("classpath*:applicationContext-rabbitMq.xml")
public class AppTest extends AbstractJUnit4SpringContextTests {

    ApplicationContext applicationContext;
    public AppTest() {
        super();
    }
    @Autowired
    private AConsumer aConsumer;
    @Autowired
    private BConsumer bConsumer;
    @Autowired
    private CConsumer cConsumer;
    @Autowired
    private OtherConsumer otherConsumer;
    @Autowired
    private GaofeiMqProducer gaofeiMqProducer;

    @Test
    public void testMq() {
        while (true) {
            for (int i = 0; i < 10; i++) {
                gaofeiMqProducer.sendDataToQueue("a.b.c", "topic message a.b.c" + i);
                gaofeiMqProducer.sendDataToQueue("a.c", "topic message a.c" + i);
                gaofeiMqProducer.sendDataToQueue("a.x", "topic message a.x" + i);
                gaofeiMqProducer.sendDataToQueue("other", "direct message" + i);
                try {
                    Thread.sleep(30 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
