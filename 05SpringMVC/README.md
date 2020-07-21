# SpringMVC

## 创建SpringMVC项目
**使用maven创建项目时，加入archetypeCatalog:internal,避免项目创建过慢**
### 依赖环境 
1.spring-context  
2.spring-web  
3.spring-webmvc  
4.servlet-api  
5.jsp-api 

##入门案例

1.前端控制器：DispatcherServlet    
2.处理器映射器：HandlerMapping  
3.视图解析器：ViewResolver  
4.处理器适配器：HandlerAdapter

***配置springmvc注解支持，相当于配置了处理器适配器跟处理器映射器***

### RequestMapping注解
属性：  
  1.path  
  2.method    
  3.headers  
  4.params  
  
## 请求参数绑定
> 1.基本数据类型&字符串  
> 2.实体类型：JavaBean中如果有其他引用类型，表单name属性封装为对象.属性方式   
> 3.数组或集合类型  
> 4.Servlet原生API

### 中文编码过滤器
> CharacterEncodingFilter  

### 自定义类型转换器
> ConversionServiceFactoryBean

## SpringMVC常用注解

### @RequestParam
> 作用：把请求中的指定名称参数给控制器中的形参赋值  
> 属性：value，required

### @RequestBody
> 作用：获取请求体数据，get请求不适用  
> 属性：required

### @PathVariable
> 作用：绑定URL中的占位符  
> 属性：value，required

### @CookieValue
> 作用：用于把指定cookie的值给控制器中的形参赋值  
> 属性：value，required

### @RequestHeader
> 作用：用于获取指定请求头
> 属性：value，required

### @ModelAttribute
> 作用：用于给控制器形参赋值预处理，可以修饰方法跟参数，出现在方法上，表示当前方法会在控制器方法执行之前执行，方法可以有返回值，也可以没有返回值。
>属性：value，作用在参数上时生效，用于指定获取数据的key

### @SessionAttributes
> 作用：将数据存入session中，用于控制器间数据共享  
> 属性： value  
> Model类：addAttribute():将数据存入request域  
> ModelMap类：get():用于取出session域中的数据  
> SessionStatus类:setComplete():用于删除session域中的数据
