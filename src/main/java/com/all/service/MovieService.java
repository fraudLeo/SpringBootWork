package com.all.service;

import com.all.domain.Movie;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

public interface MovieService extends IService<Movie> {
    IPage<Movie> getPage(int currentPage, int pageSize);
    IPage<Movie> getPage(int currentPage, int pageSize,Movie movie);
}
