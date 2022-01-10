package com.all.dao;

import com.all.domain.Movie;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
public class MovieDaoTestCase {

    @Autowired
    private MovieDao movieDao;

    @Test
    void testGetbyId() {
        System.out.println(movieDao.selectById(1));
    }
    @Test
    void testSave() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date();
        Movie movie = new Movie();

        movie.setImg("asads");
        movieDao.insert(movie);
    }
    @Test
    void testUpdate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date();
        Movie movie = new Movie();
        Integer id = 222;

        movie.setId(id);
        movie.setImg("asads");
        movieDao.updateById(movie);
    }
    @Test
    void testDelete() {
        Integer id = 222;
        movieDao.deleteById(id);
    }
    @Test
    void testGetAll() {
        movieDao.selectList(null);
    }
    @Test
    void testGetPage() {
        IPage page = new Page(1, 5);

        movieDao.selectPage(page,null);
        System.out.println(page.getPages());


    }
}
