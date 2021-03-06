package com.example.Spring_Batch.web;

import com.example.Spring_Batch.BankTransactionItemAnalystProcessor;
import org.springframework.batch.core.*;

import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BankRestController {
    @Autowired private JobLauncher jobLauncher;
    @Autowired private Job job;
    @Autowired private BankTransactionItemAnalystProcessor bankTransactionItemAnalystProcessor;
    @GetMapping("/startJob")
    public BatchStatus load() throws Exception {
        Map<String, JobParameter> parameters=new HashMap<>();
        parameters.put("time",new JobParameter(System.currentTimeMillis()));
        JobParameters jobParameters = new JobParameters(parameters);
        JobExecution jobExecution = jobLauncher.run(job,jobParameters);
        while (jobExecution.isRunning()){
            System.out.println("...");
        }
        return jobExecution.getStatus();
    }

    @GetMapping("/analytics")
    public Map<String,Double> analytics(){
        Map<String,Double> map = new HashMap<>();
        map.put("totale Credit",bankTransactionItemAnalystProcessor.getTotaleCredit());
        map.put("totale Debit",bankTransactionItemAnalystProcessor.getTotaleDebit());
        return map;
    }
}
