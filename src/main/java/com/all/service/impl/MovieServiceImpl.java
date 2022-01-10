package com.all.service.impl;

import com.all.dao.MovieDao;
import com.all.domain.Movie;
import com.all.service.MovieService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl extends ServiceImpl<MovieDao, Movie> implements MovieService {
    @Autowired
    private MovieDao movieDao;



    @Override
    public IPage<Movie> getPage(int currentPage, int pageSize) {
        IPage<Movie> page = new Page(currentPage,pageSize);
        movieDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<Movie> getPage(int currentPage, int pageSize, Movie movie) {

        LambdaQueryWrapper<Movie> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(movie.getName()),Movie::getName,movie.getName());
        lqw.like(Strings.isNotEmpty(movie.getType()),Movie::getType,movie.getType());
        lqw.like(Strings.isNotEmpty(movie.getActor()),Movie::getActor,movie.getActor());

        IPage<Movie> page = new Page(currentPage, pageSize);
        return movieDao.selectPage(page,lqw);
    }
}
