package com.southwind.test;

import com.southwind.entity.Account;
import com.southwind.entity.Student;
import com.southwind.entity.User;
import com.southwind.repository.StudentRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Test {
    public static void main(String[] args) {
        //加载MyBatis配置文件
        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        StudentRepository studentRepository = sqlSession.getMapper(StudentRepository.class);
//        Student student = studentRepository.findById(1L);
//        System.out.println(student.getClasses().getName());
        String statement = "com.southwind.mapper.UserMapper.get";
        User user = sqlSession.selectOne(statement , 1);
        System.out.println(user);
    }
}
