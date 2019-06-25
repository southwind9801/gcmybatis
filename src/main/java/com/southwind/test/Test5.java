package com.southwind.test;

import com.southwind.entity.Account;
import com.southwind.entity.User;
import com.southwind.repository.AccountRepository;
import com.southwind.repository.UserRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Test5 {
    public static void main(String[] args) {
        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserRepository userRepository = sqlSession.getMapper(UserRepository.class);
        User user = new User();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        user.setIds(ids);
        List<User> list = userRepository.getByIds(user);
        for(User item : list){
            System.out.println(item);
        }

    }
}
