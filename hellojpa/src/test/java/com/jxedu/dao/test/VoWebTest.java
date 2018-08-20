package com.jxedu.dao.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextHierarchy(value = {
        @ContextConfiguration(locations = {"classpath:applicationContext-jpa.xml"}),
        @ContextConfiguration(locations = {"classpath:springmvc.xml"})
})
@WebAppConfiguration
public class VoWebTest {


    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;


    Logger logger = LoggerFactory.getLogger(getClass());

    @Before
    public void init() {

        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }


    @Test
    public void testpersonget() throws Exception {

        String contentAsString = mockMvc.perform(get("/person/1").contentType(MediaType.APPLICATION_JSON_UTF8)).
                                                     andExpect(status().isOk())

                                                /*     .andExpect(jsonPath("$.result.name").value("保存或修改"))*/
                                                    .andReturn().getResponse().getContentAsString();

        logger.debug("返回结果{}", contentAsString);

    }

}
