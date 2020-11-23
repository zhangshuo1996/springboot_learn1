package com.didispace.charpter11;

import com.didispace.charpter11.domain.Video;
import com.didispace.charpter11.service.VideoService;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Charpter11Application.class})
@AutoConfigureMockMvc
public class VideoTest {
    @Autowired
    private VideoService videoService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testVideoListApi() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/pub/video/list"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        int status = mvcResult.getResponse().getStatus();

        System.out.println(status);
        // 使用下面的语句会出现乱码
//        String result = mvcResult.getResponse().getContentAsString();

        // 使用下面的语句更新编码格式后不会出现乱码
        String result = mvcResult.getResponse().getContentAsString(Charset.forName("utf-8"));
        System.out.println(result);
    }

    // 常用注解
    @Before
    public void testBefore(){
        System.out.println(" test before");
    }

    @Test
    public void testVideoList(){
        List<Video> videoList = videoService.listVideo();

        TestCase.assertTrue(videoList.size() > 0);
    }

//    @Test
//    public void testTest1(){
//        System.out.println("test Tes t1");
//
//        TestCase.assertEquals(1,2);
//    }
//
//    @Test
//    public void testTest2(){
//        System.out.println("test Test2");
//    }

    @After
    public void testAfter(){
        System.out.println("test After");
    }


}
