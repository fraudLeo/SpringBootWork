package com.all.controller;

import com.all.controller.utils.Result;
import com.all.domain.Movie;
import com.all.service.MovieService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/movie/api/v1")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/getAll")
    public Result getAll () {
        return new Result (true,movieService.list());
    }

    @PostMapping("/save")
    public Result save(@RequestBody Movie movie) throws IOException {

        if (movie.getName().equals(null)) throw new IOException();
        boolean flag = movieService.save(movie);
        return new Result(flag,flag?"\"成功^_^\"":"\"失败-_-\"");
    }
    @PostMapping("/update")
    public Result update(@RequestBody Movie movie) throws IOException{
        if (movie.getName().equals(null)) throw new IOException();
        boolean flag = movieService.updateById(movie);
        return new Result(flag,flag?"\"成功^_^\"":"\"失败-_-\"");
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id ) {
        return new Result(true, movieService.removeById(id));
    }
    @GetMapping("/getById/{id}")
    public Result getById(@PathVariable Integer id) {
        return new Result(true,movieService.getById(id));
    }
    @GetMapping("/currentPage/{currentPage}/pageSize/{pageSize}")
    public Result getPage(@PathVariable int currentPage,@PathVariable int pageSize,Movie movie) {
        IPage<Movie> page = movieService.getPage(currentPage,pageSize,movie);
        if (currentPage>page.getPages()) {
            page = movieService.getPage((int)page.getPages(),pageSize,movie);
        }
        return new Result(true,page);
    }
    //这里想做按条件排序
    @GetMapping("/orderBy/upgrade/queryColumnName/{queryColumnName}/val/{val}/columnName/{columnName}")
    public Result orderByUP(@PathVariable String queryColumnName,@PathVariable double val,@PathVariable String columnName) {
        return new Result(true,movieService.orderByUP(queryColumnName,val,columnName));
    }

    @GetMapping("/orderBy/downgrade/queryColumnName/{queryColumnName}/val/{val}/columnName/{columnName}")
    public Result orderByDown(@PathVariable String queryColumnName,@PathVariable double val,@PathVariable String columnName) {
        return new Result(true,movieService.orderByDown(queryColumnName, val,columnName));
    }

}
