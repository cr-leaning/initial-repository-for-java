// TODO Resolve mybatis setup
//package com.nekose.sampleproject.config;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.ibatis.session.ExecutorType;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
//@Slf4j
//@Configuration
//@MapperScan("com.nekose.sampleproject.infrastructure.rdb.mapper")
//@RequiredArgsConstructor
//public class DatasourceConfig {
//    private final DataSource dataSource;
//    private final MybatisProperties mybatisProperties;
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactory() throws Exception {
//        new SqlSessionFactoryBuilder().
//        var sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(this.dataSource);
//        sqlSessionFactoryBean.setConfiguration(mybatisProperties.getConfiguration());
//        return sqlSessionFactoryBean.getObject();
//    }
//
//    @Bean
//    public SqlSessionTemplate batchSqlSessionTemplate(SqlSessionFactory sessionFactory) {
//        return new SqlSessionTemplate(sessionFactory, ExecutorType.BATCH);
//    }
//
//    @Primary
//    @Bean
//    public SqlSessionTemplate simpleSqlSessionTemplate(SqlSessionFactory sessionFactory) {
//        return new SqlSessionTemplate(sessionFactory, ExecutorType.SIMPLE);
//    }
//}
