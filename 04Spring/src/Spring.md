# Spring框架
## IOC控制反转
> 作用：降低计算机程序的耦合，即代码之间的依赖关系。  
> 实现原理：反射+配置文件  

### Spring的IOC核心容器对象
> 1.ApplicationContext：单例，BeanFactory的子类  
> 2.BeanFactory：多例  
> 区别：
>> 创建对象的时间点不同，ApplicationContext是读取配置文件后立即创建对象，BeanFactory是什么时候使用对象什么时候创建，属于延迟创建。

### ApplicationContext接口实现类
> 1.ClassPathXmlApplicationContext  
> 2.FileSystemXmlApplicationContext
> 3.AnnotationConfigApplicationContext

### bean标签
> 属性：id,class,scope,init-method,destroy-method

### Bean对象的作用范围
> 1.singleton 单例（常用）  
> 2.prototype 多例（常用）  
> 3.request 作用于Web项目，Spring创建Bean对象存储在request域    
> 4.session 作用于Web项目，Spring创建Bean对象存储在session域   
> 5.global session 作用于Web项目，集群环境  

### Bean对象生命周期
> 1.单例对象:创建容器，对象创建，容器销毁，对象销毁  
> 2.多例对象：使用对象，对象创建，对象长期不用，java垃圾回收器回收销毁

### IOC容器实例化Bean对象方式
> 1.默认无参构造   
> 2.静态工厂：factory-method  
> 3.实例工厂:factory-method,factory-bean  

## DI依赖注入

> 作用：通过依赖注入配置方式，让Spring为成员变量赋值

### 构造函数注入

> 标签:constructor-arg,属性：name,value(基本数据类型，String类型),ref（bean.xml中声明的bean类型）

### set方法注入

> 标签：property，属性：name,value,ref

#### 注入集合属性
注意：结构相同，标签可互换
> List:list,array,set  
> Map:map,entry,props,prop

## 基于注解的IOC配置

### 创建对象的注解
@Component:把当前类的对象存入Spring容器
属性：value,用于指定bean的ID,如果不指定，那么使用当前类名，首字母小写
配置xml,告知spring容器要扫描的包:  
<context:component-scan base-package="cn.anno"></context:component-scan>  
衍生注解：
  @Controller:表现层
  @Service:业务层
  @Repository:数据层

### 注入数据的
  @AutoWired:自动按照类型注入，要求容器中有唯一的Bean类型与要注入的变量匹配，可注入成功，如果有多个，则根据变量名为Bean的id继续寻找，如果找到则注入成功。
  @Qulifier:指定bean的id，配合@AutoWired使用，用于多个Bean类型查找。
  @Resource:直接按照bean的id查找,属性为name
  @Value：基本数据类型跟String类型数据注入

### 改变作用范围
@Scope
### 生命周期相关
@PostConstruct,@PreDestroy

## Spring新注解
### @Configuration
> 作用：指定当前类是一个配置类
### @ComponentScan
> 作用：指定要访问的包
### @Bean
> 作用：将当前方法的返回值存入Spring IOC容器,如果为指定name属性，那么会使用当前方法名作为bean的id。
### @Import
> 作用：导入其它配置类

### @PropertySource
> 作用：指定properties文件的位置

### @Qualifier
> 作用在方法参数上

### Junit与Spring整合
> 1.spring-test jar包  
> 2.@Runwith(SpringJunit4ClassRunner.class)  
> 3.@ContextConfiguration:
>> locations:xml文件位置  
>> classes:注解的类  

>4.使用@Autowired注入数据

## AOP面向切面编程
> 依赖环境：aspectjweaver
> 作用：在程序运行时，不修改源码对已有方法增强，减少代码冗余。  
> 原理：动态代理技术

> 切入点（PointCut）：被增强的方法  
> 切面（Aspect）：被增强的方法&通知  
> 织入（Weaving）：把增强应用到目标对象创建代理对象的过程
> 通知（Advice）：提供公共代码的类，分为：前置通知，后置通知，异常通知，最终通知，环绕通知  
>  目标对象（Target）  
> 代理对象（Proxy）

### 环绕通知
 Spring提供手动控制增强方法何时执行的方式，相当于动态代理中invoke执行的代码

###  切点表达式
> 修饰符 返回值 包名 类名 方法名（参数）  
> 修饰符可省略  
> 包名可以使用..代表当前包及其子包  
> 参数列表使用..代表有参数无参数都可

### 基于XML的AOP配置  
 1.把通知bean交给Spring管理  
 2.配置AOP  
 3.配置切面  
 4.配置通知的类型及切入点  
 
 ### 基于注解的AOP配置
 @Aspect  
 @Pointcut  
 @Before  
 @AfterReturning  
 @AfterThrowing  
 @After  
 @Around  
 @EnableAspectJAutoProxy:开启AOP注解支持    
 注意：基于注解的AOP配置，最终通知会在后置通知之前执行，这种情况下使用环绕通知方式替代。
 
 ## Spring JdbcTemplate
 依赖环境：spring-jdbc
 spring提供了JdbcDaoSupport类可以减少不同dao之间重复声明，这种方式只能应用于xml
 
 ## Spring事务控制
 依赖环境:spring-tx
 数据库引擎必须是InnoDB才支持事务操作
 
 ### 基于XML的声明式事务控制
 > spring中基于XML的声明式事务控制配置步骤  
           1、配置事务管理器  
           2、配置事务的通知   
           3、配置AOP中的通用切入点表达式  
           4、建立事务通知和切入点表达式的对应关系  
           5、配置事务的属性  
                 
 
 ### 基于注解的声明式事务控制
 @EnableTransactionManagement:开启注解事务支持
 @Transactional:配置事务属性