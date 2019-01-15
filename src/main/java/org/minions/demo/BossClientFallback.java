package org.minions.demo;

import feign.hystrix.FallbackFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * @author s.nechkin
 */
@Component
public class BossClientFallback implements FallbackFactory<BossClient> {

    private static final Log log = LogFactory.getLog(BossClientService.class);

    @Override
    public BossClient create(Throwable cause) {
        return minion -> {
            log.error("--- This Boss not available now, please come back later (Fallback) client:" + minion);
            log.error("Cause:" + cause.getMessage());
            return Application.FIND_A_BOSS_TASK;
        };
    }
}
