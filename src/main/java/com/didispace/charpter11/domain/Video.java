package com.didispace.charpter11.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class Video {

    private int id;

    private String title;

    private String summary;

    private int price;

//    @JsonInclude(JsonInclude.Include.NON_NULL)
//    @JsonProperty("cover_image")
    private String coverImg;

    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",locale="zh",timezone="GMT+8")
    private Date createTime;

    private List<Chapter> chapterList;

    public List<Chapter> getChapterList() {
        return chapterList;
    }

    public void setChapterList(List<Chapter> chapterList) {
        this.chapterList = chapterList;
    }

    public Video(){}

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", price=" + price +
                ", coverImg='" + coverImg + '\'' +
                ", createTime=" + createTime +
                ", chapterList=" + chapterList +
                '}';
    }

    public Video(int id, String title){
        this.id = id;
        this.title = title;

        this.createTime = new Date();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public int getPrice() {
        return price;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
