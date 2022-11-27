package com.example.springbatch;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DBJobConfiguration {
    /**
     * Job 관련 테이블

     - BATCH_JOB_INSTANCE
     ● job 이 실행될 때 JobInstance 정보가  저장되며 job_name과 job_key를 키로 하여 하나의 데이터가 저장
     ● 동일한 job_name과 job_key로 중복 저장될 수 없다.

     - BATCH_JOB_EXECUTION
     ● job의 실행 정보가 저장되며 job 생성, 시작, 종료 시간, 실행상태, 메세지등을 관리

     - BATCH_JOB_EXECUTION_PARAM
     ● job과 함께 실행되는 JobParameter 정보를 저장

     - BATCH_JOB_EXECUTION_CONTEXT
     ● Job 의 실행동안 여러가지 상태정보, 공유 데이터를 직렬화(JSON 형식)해서 저장
     ● Step 간 서로 공유 가능함

     * STEP 관련 테이블
     - BATCH_STEP_EXECUTION
     ● Step의 실행정보가 저장되며 생성, 시작, 종료 시간, 실행상태, 메세지등을 관리

     -BATCH_STEP_EXECUTION_CONTEXT
     ● Step의 실행동안 여러가지 상태정보, 공유 데이터를 직렬화(JSON 형식)해서 저장
     ● Step 별로 저장되며 Step 간 서로 공유할 수 없음

     */

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job job() {
        return jobBuilderFactory.get("job")
                .start(step1())
                .next(step2())
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        System.out.println("step1 was executed");
                        return RepeatStatus.FINISHED;
                    }
                })
                .build();
    }

    @Bean
    public Step step2() {
        return stepBuilderFactory.get("step2")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        System.out.println("step2 was executed");
                        return RepeatStatus.FINISHED;
                    }
                })
                .build();
    }
}
