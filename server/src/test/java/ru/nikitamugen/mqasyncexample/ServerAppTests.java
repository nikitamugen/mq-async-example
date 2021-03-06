package ru.nikitamugen.mqasyncexample;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServerAppTests {

	private static ApplicationContext applicationContext;

    private static Logger logger = Logger.getLogger(TestSender.class);

	@Autowired
	void setContext(ApplicationContext applicationContext) {
		ServerAppTests.applicationContext = applicationContext;
	}

	@AfterClass
	public static void afterClass() {
	    if (Objects.nonNull(applicationContext)) {
            ((ConfigurableApplicationContext) applicationContext).close();
        }
	}

    @Autowired
    private TestSender sender;

	@Autowired
    private TestConsumer consumer;

	@Test
	public void receiveTest() throws Exception {
	    sender.send("some");

	    // Wait a sec to be sure
        // that a request has been received
        //
        CountDownLatch consumerLatch = consumer.getLatch();
        consumerLatch.await(3000, TimeUnit.MILLISECONDS);
	    Long expectedConsumerLatchCount = 0L;
	    Long actualConsumerLatchCount = consumerLatch.getCount();
        Assert.assertEquals(expectedConsumerLatchCount, actualConsumerLatchCount);

        // Wait a sec to be sure
        // that a response has been received
        //
        CountDownLatch senderLatch = sender.getLatch();
        senderLatch.await(3000, TimeUnit.MILLISECONDS);
        Long expectedSenderLatchCount = 0L;
        Long actualSenderLatchCount = senderLatch.getCount();
        Assert.assertEquals(expectedSenderLatchCount, actualSenderLatchCount);
	}
}
