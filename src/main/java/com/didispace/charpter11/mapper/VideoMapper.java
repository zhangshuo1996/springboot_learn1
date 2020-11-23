package com.didispace.charpter11.mapper;

import com.didispace.charpter11.domain.Video;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository// spring会将此类自动实例化
public class VideoMapper {

    private static Map<Integer, Video> videoMap = new HashMap<>();

    static {
        videoMap.put(1, new Video(1, "java基础1"));
        videoMap.put(2, new Video(2, "java基础2"));
        videoMap.put(3, new Video(3, "java基础3"));
        videoMap.put(4, new Video(4, "java基础4"));
        videoMap.put(5, new Video(5, "java基础5"));
        videoMap.put(6, new Video(6, "java基础6"));
    }

    public List<Video> listVideo(){
        List<Video> list = new ArrayList<>();
        list.addAll(videoMap.values());
        return list;
    }
}
