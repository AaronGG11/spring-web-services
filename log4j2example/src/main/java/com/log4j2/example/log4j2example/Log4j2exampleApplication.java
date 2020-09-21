package com.log4j2.example.log4j2example;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2exampleApplication
{
	private static Logger logger = LogManager.getLogger(Log4j2exampleApplication.class);

	public static void main(String[] args)
	{
		logger.fatal("fatal log");
		logger.error("error log");
		logger.warn("warn log");
		logger.info("info log");
		logger.debug("debug log");
		logger.trace("trace log");
	}
}
