package com.didispace.charpter11.service.impl;

import com.didispace.charpter11.domain.Video;
import com.didispace.charpter11.mapper.VideoMapper;
import com.didispace.charpter11.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Component
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public List<Video> listVideo() {
        return videoMapper.listVideo();
    }
}
