package com.hjljy.blog.service;

import org.springframework.stereotype.Service;

/**
 * @Auther: HJLJY
 * @Date: 2019/1/10 0010 14:39
 * @Description:
 */
@Service
public class TestService {

    public int get() throws Exception{
        return 1/0;
    }
}
