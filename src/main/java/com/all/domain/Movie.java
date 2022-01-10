package com.all.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("movie")
public class Movie {

    private Integer id;
    private String name;
    private double score;
    private String img;
    private String actor;
    private String url;
    private Date time;
    private String type;
}
