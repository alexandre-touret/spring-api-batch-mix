package info.touret.batchapimix.batch;

import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.StepContribution;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.infrastructure.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class LogHelloTasklet implements Tasklet {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogHelloTasklet.class);
    @Override
    public @Nullable RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        LOGGER.info("Hello World!");
        Thread.sleep(10_000);
        return RepeatStatus.FINISHED;
    }
}
