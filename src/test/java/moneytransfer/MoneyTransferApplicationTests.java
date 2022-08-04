package moneytransfer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MoneyTransferApplicationTest {
    @Autowired
    TestRestTemplate restTemplate;
    private static final int PORT = 5500;
    @Container
    public static GenericContainer<?> transferApp = new GenericContainer<>("transferapp")
            .withExposedPorts(PORT);

    @BeforeAll
    public static void setUp() {
        transferApp.start();
    }

    @Test
    void contextLoads() {
        final var devEntity = restTemplate.getForEntity("http://localhost:" + transferApp.getMappedPort(PORT) + "/logs", String.class);
        Assertions.assertEquals("[]", devEntity.getBody());
    }
}
