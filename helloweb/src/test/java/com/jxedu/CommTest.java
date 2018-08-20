package com.jxedu;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommTest {

    Logger logger = LoggerFactory.getLogger(getClass());
      @Test
     public void testutils(){

           logger.info("生成的随机数{}",RandomStringUtils.randomNumeric(4));

          logger.info("圆顶地硒鼓 ");
      }
}
