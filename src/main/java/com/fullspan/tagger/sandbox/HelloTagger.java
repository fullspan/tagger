package com.fullspan.tagger.sandbox;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class HelloTagger
{
  private static final DateFormat TIMESTAMP_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S z");
  private static final Logger LOG = LogManager.getLogger(HelloTagger.class);
  
  static
  {
    BasicConfigurator.configure();
  }
  
  public String getGreeting() throws Exception
  {
    LOG.debug("Generating greeting");
    InputStream greetingStream = getClass().getResourceAsStream("/greeting.txt");
    String greeting = null;
    
    try
    {
      greeting = IOUtils.toString(greetingStream).trim();
    }
    finally
    {
      greetingStream.close();
    }
    
    greeting = greeting + " " + TIMESTAMP_FORMAT.format(new Date());
    LOG.info(greeting);
    
    return greeting;
  }
}
