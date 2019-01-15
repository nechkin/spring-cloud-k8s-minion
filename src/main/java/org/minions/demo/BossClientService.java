package org.minions.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BossClientService {

    //private final RestTemplate restTemplate;

    private final BossClient bossClient;

    @Value("${bossUrl}")
    private String bossUrl;

    private static final Log log = LogFactory.getLog(BossClientService.class);

    public BossClientService(BossClient bossClient) {
        this.bossClient = bossClient;
    }

    // @HystrixCommand(fallbackMethod = "getFallbackName", commandProperties = {
    //         @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    // })
    public String requestMission(String from) {

        log.info("--- Requesting a task to Boss: " + bossUrl);
        return bossClient.mission(from);

        // String url = String.format("%s/mission/%s",
        //                            to,
        //                            from);
        //
        // return restTemplate.getForObject(url, String.class);
    }
}
