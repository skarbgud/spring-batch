//package com.example.springbatch;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.JobParameters;
//import org.springframework.batch.core.JobParametersBuilder;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class JobRunner implements ApplicationRunner {
//
//    @Autowired
//    private JobLauncher jobLauncher;
//
//    @Autowired
//    public Job job;
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//
//        JobParameters jobParameters = new JobParametersBuilder()
//                .addString("name", "user2")
//                .toJobParameters();
//
//        //이미 동일한 파라미터로 실행된 job 파라미터가 있기 때문에 수행할 수 없다고 나옴 => job 파라미터에 대한 값을 다르게 설정
//        jobLauncher.run(job, jobParameters);
//    }
//}
