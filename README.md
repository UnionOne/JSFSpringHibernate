##JSF 2 + Spring 4 + Hibernate integration

###First of all add dependencies to pom.xml:
[pom.xml](https://github.com/UnionOne/JSFSpringHibernate/blob/master/pom.xml#L20-L25)
```xml
        ...
        <!-- Spring and Transactions -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-core</artifactId>
            <version>${spring-framework.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-tx</artifactId>
            <version>${spring-framework.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>${spring-framework.version}</version>
        </dependency>
        
        <!-- Spring ORM support -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-orm</artifactId>
            <version>${spring-framework.version}</version>
        </dependency>

        <!-- Hibernate -->
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-entitymanager</artifactId>
            <version>${hibernate.version}</version>
        </dependency>
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-core</artifactId>
            <version>${hibernate.version}</version>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.9</version>
        </dependency>
        <dependency>
            <groupId>commons-dbcp</groupId>
            <artifactId>commons-dbcp</artifactId>
            <version>1.4</version>
        </dependency>
        ...
```

###Then add some lines to faces-config.xml:
[faces-config.xml](https://github.com/UnionOne/JSFSpringHibernate/blob/master/src/main/webapp/WEB-INF/faces-config.xml#L7-L11)
```xml
    <application>
        <el-resolver>
            org.springframework.web.jsf.el.SpringBeanFacesELResolver
        </el-resolver>
    </application>
```

###Configure saint applicationContext.xml in resources folder:
[applicationContext.xml](https://github.com/UnionOne/JSFSpringHibernate/blob/master/src/main/resources/spring/applicationContext.xml)
```xml
  ...
  <beans:bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
        <beans:property name="driverClassName" value="com.mysql.jdbc.Driver"/>
        <beans:property name="url" value="jdbc:mysql://127.0.0.2:3306/schema"/>
        <beans:property name="username" value="root"/>
        <beans:property name="password" value="root"/>
  </beans:bean>
  ...
```

###Configure saint hibernate.cfg.xml in resources folder to mapping model classes:
[hibernate.cfg.xml](https://github.com/UnionOne/JSFSpringHibernate/blob/master/src/main/resources/hibernate/hibernate.cfg.xml)
```xml
  ...
  <hibernate-configuration>
        <session-factory>
                <mapping class="com.itibo.spring.model.Person"/>
        </session-factory>
  </hibernate-configuration>
  ...
```

###Add listener and context-param to web.xml:
[web.xml](https://github.com/UnionOne/JSFSpringHibernate/blob/master/src/main/webapp/WEB-INF/web.xml#L10-L16)
```xml
        ...
    <!-- Add Support for Spring -->
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
    <listener>
        <listener-class>org.springframework.web.context.request.RequestContextListener</listener-class>
    </listener>
    
    <!-- Context-param -->
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:spring/applicationContext.xml</param-value>
    </context-param>
        ...
```

###Create new table in some schema:
[setup.sql](https://github.com/UnionOne/JSFSpringHibernate/blob/master/src/main/resources/setup.sql)
```sql
  CREATE TABLE `Person` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '',
  `country` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```

###CRUD or other opearations with data base entity:
[PersonDaoImpl.java](https://github.com/UnionOne/JSFSpringHibernate/blob/master/src/main/java/com/itibo/spring/dao/PersonDaoImpl.java#L16)
```java
...
@Repository
public class PersonDaoImpl implements PersonDao {
    private static final Logger logger = LoggerFactory.getLogger(PersonDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
...
```

###Persistence annotation:
[Person.java](https://github.com/UnionOne/JSFSpringHibernate/blob/master/src/main/java/com/itibo/spring/model/Person.java#L10-L19)
```java
...
@Entity
@Table(name = "PERSON")
@ManagedBean(name = "person")
public class Person {
    private int id;
    private String name;
    private String country;
...
```

###Spring service layer for buisness logic:
[PersonServiceImpl.java](https://github.com/UnionOne/JSFSpringHibernate/blob/master/src/main/java/com/itibo/spring/service/PersonServiceImpl.java#L16-L20)
```java
...
@Service
@ManagedBean(name = "personService")
@SessionScoped
public class PersonServiceImpl implements PersonService {
    private PersonDao personDao;
...
```
