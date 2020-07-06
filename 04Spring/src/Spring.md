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
