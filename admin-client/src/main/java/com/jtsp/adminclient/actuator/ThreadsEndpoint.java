package com.jtsp.adminclient.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Endpoint(id = "threads")
public class ThreadsEndpoint {

    @ReadOperation
    public Map<String, Object> threads() {
        Map<String, Object> threadDetails = new HashMap<>();
        ThreadGroup rootThreadGroup = getRootThreadGroup();
        Thread[] threads = new Thread[rootThreadGroup.activeCount()];
        rootThreadGroup.enumerate(threads, true);

        for (Thread thread : threads) {
            if (thread != null) {
                Map<String, Object> details = new HashMap<>();
                details.put("isDaemon", thread.isDaemon());
                details.put("state", thread.getState());
                threadDetails.put(thread.getName(), details);
            }
        }
        return threadDetails;
    }

    private ThreadGroup getRootThreadGroup() {
        ThreadGroup rootThreadGroup = Thread.currentThread().getThreadGroup();
        while (rootThreadGroup.getParent() != null) {
            rootThreadGroup = rootThreadGroup.getParent();
        }
        return rootThreadGroup;
    }
}

