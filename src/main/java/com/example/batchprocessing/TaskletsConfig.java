/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.batchprocessing;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
public class TaskletsConfig {
    
    @Autowired 
    private JobBuilderFactory jobs;

    @Autowired 
    private StepBuilderFactory steps;

    @Bean
    protected Step readLines() {
        return steps
          .get("readLines")
          .tasklet(new LinesReader())
          .build();
    }

    @Bean
    protected Step processLines() {
        return steps
          .get("processLines")
          .tasklet(new LinesProcessor())
          .build();
    }

    @Bean
    protected Step writeLines() {
        return steps
          .get("writeLines")
          .tasklet(new LinesWriter())
          .build();
    }

    @Bean
    public Job job() {
        return jobs
          .get("taskletsJob")
          .start(readLines())
          .next(processLines())
          .next(writeLines())
          .build();
    }
}
