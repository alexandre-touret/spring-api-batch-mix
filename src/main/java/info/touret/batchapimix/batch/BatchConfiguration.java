package info.touret.batchapimix.batch;

import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.job.parameters.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.Step;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@Profile("batch")
public class BatchConfiguration {

    private final LogHelloTasklet logHelloTasklet;
    public BatchConfiguration(LogHelloTasklet logHelloTasklet) {
        this.logHelloTasklet = logHelloTasklet;
    }

    @Bean
    public Step helloStep(JobRepository jobRepository,
                          PlatformTransactionManager transactionManager) {
        return new StepBuilder("helloStep", jobRepository)
                .tasklet(logHelloTasklet, transactionManager)
                .build();
    }

    /**
     * Job principal qui affiche "hello" toutes les 10 secondes
     */
    @Bean
    public Job helloJob(JobRepository jobRepository, Step helloStep) {
        return new JobBuilder("helloJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(helloStep)
                .build();
    }
}
