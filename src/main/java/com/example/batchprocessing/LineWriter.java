/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.batchprocessing;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemWriter;

public class LineWriter implements 
  ItemWriter<Line>, StepExecutionListener {

    private final Logger logger = LoggerFactory
      .getLogger(LinesWriter.class);
 
    private FileUtils fu;

    @Override
    public void beforeStep(StepExecution stepExecution) {
        this.fu = new FileUtils("output2.csv");
        logger.debug("Line Writer initialized.");
    }

    @Override
    public void write(List<? extends Line> lines) throws Exception {
        for (Line line : lines) {
            this.fu.writeLine(line);
            logger.debug("Wrote line " + line.toString());
        }
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        this.fu.closeWriter();
        logger.debug("Line Writer ended.");
        return ExitStatus.COMPLETED;
    }
}
