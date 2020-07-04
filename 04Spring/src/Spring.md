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