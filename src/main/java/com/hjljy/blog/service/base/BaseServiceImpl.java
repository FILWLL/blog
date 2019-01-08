package com.hjljy.blog.service.base;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hjljy.blog.common.PageData;
import com.hjljy.blog.mapper.base.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Optional;

/**
 * @Auther: HJLJY
 * @Date: 2018/11/28 0028 18:10
 * @Description:
 */
@Service
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    private BaseMapper<T> mapper;


    @Override
    public boolean insert(T entity) {
        return mapper.insertSelective(entity) > 0;
    }


    @Override
    public boolean insertSelective(T entity) {
        return mapper.insertSelective(entity) > 0;
    }


    @Override
    public boolean deleteById(Object key) {
        return mapper.deleteByPrimaryKey(key) > 0;
    }

    @Override
    public T selectById(Object key) {
        return mapper.selectByPrimaryKey(key);
    }


    @Override
    public boolean updateById(T entity) {
        return mapper.updateByPrimaryKey(entity) > 0;
    }


    @Override
    public boolean updateSelectiveById(T entity) {
        return mapper.updateByPrimaryKeySelective(entity) > 0;
    }

    @Override
    public List<T> listAll() {
        return this.mapper.selectAll();
    }

    @Override
    public PageInfo<T> listForDataGrid(PageData grid) {
        return this.listForDataGrid(grid, null);
    }

    @Override
    public PageInfo<T> listForDataGrid(PageData grid, Example entity) {
        PageHelper.startPage(grid.getPage(), grid.getLimit(),grid.getOrderBy());
        return new PageInfo<>(mapper.selectByExample(entity));
    }

    @Override
    public int getCount(T entity){
        return mapper.selectCount(entity);
    }

    public boolean deleteByIds(String ids) {

        return mapper.deleteByIds(ids)> 0;
    }
}
