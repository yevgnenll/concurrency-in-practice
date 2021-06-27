package me.yevgnenll.concurrent.task;

import java.util.concurrent.Executor;

public class WithinThreadExecutor implements Executor {
    @Override
    public void execute(Runnable command) {
        command.run();
    }
}
