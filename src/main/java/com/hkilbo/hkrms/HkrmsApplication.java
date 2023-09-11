package com.hkilbo.hkrms;

import org.apache.ibatis.session.SqlSessionFactory;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.test.context.ContextConfiguration;

import javax.sql.DataSource;

@MapperScan(value = {"com.hkilbo.*"})
@ContextConfiguration(locations={"file:/webapp/WEB-INF/spring/root-context.xml"})
@SpringBootApplication(scanBasePackages={"com.hkilbo.*"})
public class HkrmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HkrmsApplication.class, args);
    }

    @Autowired
    private DataSource dataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception{
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);

        Resource[] res
                = new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml");
        sessionFactory.setMapperLocations(res);

        return sessionFactory.getObject();
    }

}
