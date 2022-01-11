package com.all.service;

import com.all.domain.Movie;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface MovieService extends IService<Movie> {
    IPage<Movie> getPage(int currentPage, int pageSize);
    IPage<Movie> getPage(int currentPage, int pageSize,Movie movie);
    List<Movie> orderByUP(String queryColumnName,double val,String columnName);
    List<Movie> orderByDown(String queryColumnName,double val,String columnName);
}
