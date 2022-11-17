package com.bitc.board2.configuration;
// board1에 있는 걸 그대로 가져다 쓰면 된다.
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
// 에러를 지우기 위해서는 빌드 그레이들 주석 처리 해제 해야 한다.
import javax.sql.DataSource;
// @Configuration : 해당 파일이 스프링 프로젝트 설정 파일임을 나타내는 어노테이션
@Configuration
//@PropertySource : 지정한 파일에서 설정 내용을 가져오는 어노테이션
// classpath : -> resource폴더를 뜻함. spring 프로젝트에서 resources 폴더를 의미.
@PropertySource("classpath:/application.properties")
public class DatabaseConfiguration {

  @Autowired
  private ApplicationContext applicationContext;

  @Bean
//    @ConfigurationProperties : 지정되어있는 파일에서 지정되어 있는 내용 가져오기
//    prefix로 지정한 설정의 내용을 가져옴 -> hikariconfig를 리턴해주겠다 application properties에서
  @ConfigurationProperties(prefix = "spring.datasource.hikari")
  public HikariConfig hikariConfig() {
    return new HikariConfig();
  }

  //    실제 데이터 베이스 연결
  @Bean
  public DataSource dataSource() throws Exception {
//        hikari cp를 사용하여 데이터 베이스 연결
    DataSource dataSource = new HikariDataSource(hikariConfig());
    System.out.println(dataSource.toString());
    return dataSource; //이거를
  }

  @Bean
  public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception { //여기서 받음
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(dataSource);
    sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources
        ("classpath:/sql/**/sql-*.xml"));
    sqlSessionFactoryBean.setConfiguration(mybatisConfig());

    return sqlSessionFactoryBean.getObject();
  }


  @Bean
  public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
    return new SqlSessionTemplate(sqlSessionFactory);
  }

  //    mybatis 설정
//    application.properties 안에 있는 걸 연결해 가져다 쓰겠다는 의미
  @Bean
  @ConfigurationProperties(prefix = "mybatis.configuration")
  public org.apache.ibatis.session.Configuration mybatisConfig() {
    return new org.apache.ibatis.session.Configuration();
  }
}