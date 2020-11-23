package com.didispace.charpter11.controller;

import com.didispace.charpter11.domain.Video;
import com.didispace.charpter11.service.VideoService;
import com.didispace.charpter11.utils.JsonData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pub/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    // @RequestMapping(value="list", method = RequestMethod.GET)
    @GetMapping("list")
    public JsonData list() throws JsonProcessingException {
        List<Video> list = videoService.listVideo();

//        // 对象序列化为字符串
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonStr = objectMapper.writeValueAsString(list);
//        System.out.println(jsonStr);
//        // 反序列化
//        List<Video> temp = objectMapper.readValue(jsonStr, List.class);
        System.out.println("hahahha");
        return JsonData.buildSuccess(list);
    }

    @PostMapping("save_video_chapter")
    public JsonData saveVideoChapter(@RequestBody Video video){
        System.out.println(video.toString());
        return JsonData.buildSuccess("");
    }


}
