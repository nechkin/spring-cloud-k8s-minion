package org.minions.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author s.nechkin
 */
@FeignClient(name = "${bossUrl}", path = "/", fallback = BossClientFallback.class)
public interface BossClient {

    @RequestMapping(method = POST, path = "/mission/{minion}")
    String mission(@PathVariable("minion") String minion);

    // @RequestMapping(method = GET, path = "/")
    // @ResponseBody
    // String boss();
}
