package com.southwind.test;

import com.southwind.entity.Classes;
import com.southwind.entity.Student;
import com.southwind.repository.ClassesRepository;
import com.southwind.repository.CustomerRepository;
import com.southwind.repository.GoodsRepository;
import com.southwind.repository.StudentRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Test3 {
    public static void main(String[] args) {
        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ClassesRepository classesRepository = sqlSession.getMapper(ClassesRepository.class);
        Classes classes = classesRepository.findByIdLazy(2L);
        System.out.println(classes);
        sqlSession.close();
        sqlSession = sqlSessionFactory.openSession();
        classesRepository = sqlSession.getMapper(ClassesRepository.class);
        Classes classes2 = classesRepository.findByIdLazy(2L);
        System.out.println(classes2);
        sqlSession.close();
    }
}
