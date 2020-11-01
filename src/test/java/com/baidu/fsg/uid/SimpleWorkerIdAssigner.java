package com.baidu.fsg.uid;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.baidu.fsg.uid.worker.WorkerIdAssigner;

/**
 * @author yumin.pym
 */
public class SimpleWorkerIdAssigner implements WorkerIdAssigner {
    private Random random = new Random();
    private Set<Integer> allocatedWorkerIdSet = new HashSet<>(16);

    @Override
    public long assignWorkerId() {
        while (true) {
            int workerId = random.nextInt(1024);
            if (allocatedWorkerIdSet.add(workerId)) {
                return workerId;
            } else {
                System.out.println("workerId has allocated, workerId:" + workerId);
            }
        }
    }
}
