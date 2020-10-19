package com.example.dataJpa;

import java.awt.EventQueue;

import javax.swing.JFrame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.dataJpa.config.layout.OdysseyAuditServiceUtilsLayout;

@SpringBootApplication
public class DataJpaApplication extends JFrame implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(DataJpaApplication.class);
	
	public static void main(String[] args) {
logger.info("CommandLineRunner has been Started !!!!!!!!!!");
    	
    	ConfigurableApplicationContext  ctx = new SpringApplicationBuilder(OdysseyAuditServiceUtilsLayout.class)
                .headless(false).run(args);

        EventQueue.invokeLater(() -> {
        	OdysseyAuditServiceUtilsLayout ex = ctx.getBean(OdysseyAuditServiceUtilsLayout.class);
        	ex.setVisible(true);
        });
	}

	@Override
	public void run(String... args) throws Exception {

		
	}

}
