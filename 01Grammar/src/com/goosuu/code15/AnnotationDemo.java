package com.goosuu.code15;

/**
 *  Annotation（注解）:
 *     作用：
 *        编写文档：javadoc：
 *            javadoc命令生成文档：
 *              格式：javadoc *.java
 *        编译检查:override
 *        代码分析:reflect
 *     常见注解：
 *        * @Override:检查标注的方法是否继承自父类（接口）
 *        * @Deprecated:表示已过时
 *        * @SuppressWarnings:压制警告
 *
 *     自定义注解：
 *       注解本质是一个接口，继承Annotation接口
 *       格式：
 *         元注解
 *         public @interface 注解名称{
 *             属性列表
 *         }
 *
 *       注解中的属性：
 *          属性：接口中的抽象方法
 *          属性的返回值类型：
 *             基本数据类型
 *             String
 *             Enum
 *             注解
 *             以上类型的数组
 *          定义了属性，需要给属性赋值：
 *             1.定义属性时，默认使用default赋值
 *             2.如果只有一个属性赋值，并且属性名称为value，直接定义值即可
 *             3.数组赋值，使用{}包裹，如果数组中只有一个值，可以省略
 *             4.注解赋值: show = @value。
 *
 *          元注解：
 *            * @Target:描述注解能够作用的位置
 *                ElementType取值：
 *                   TYPE:作用于类
 *                   METHOD:作用于方法
 *                   FIELD：作用于成员变量
 *            * @Retention:描述注解能够被保留的阶段
 *                 RetentionPolicy取值：
 *                   SOURCE
 *                   RUNTIME
 *                   CLASS
 *            * @Documented:描述注解是否被抽取到API文档中
 *            * @Inherited:描述是否被子类继承
 *
 *          解析注解：
 *            1.获取该类字节码文件对象
 *            2.获取注解对象：
 *               getAnnotation()
 *            3.调用注解对象抽象方法
 *
 *
 */

@SuppressWarnings("all")
public class AnnotationDemo {



}
