package com.goosuu.code14.test;
/**
 *
 *  测试：
 *     白盒测试：
 *        单元测试：需关注代码逻辑
 *        测试类：
 *           类名+Test
 *        测试方法：
 *           test+方法名
 *        注解：
 *          @Test,@Before,@After,@BeforeClass,@AfterClass
 *          @BeforeClass与@AfterClass只执行一次，针对静态方法
 *          一个JUnit4的单元测试用例执行顺序为：
 *             @BeforeClass -> @Before -> @Test -> @After -> @AfterClass;
 *          每一个测试方法的调用顺序为：
 *             @Before -> @Test -> @After;
 *        安装junit依赖：
 *          junit
 *          junit-4.12
 *          hamcrest-core-1.3
 *
 *     黑盒测试：
 *       简单，无需关心代码逻辑，input--->output
 *
 *
 *
 */

import com.goosuu.code14.Calculator;
import org.junit.*;

public class CalculatorTest {

    @BeforeClass
    public static void first() {
        System.out.println("first");
    }

    @Before
    public void init(){
        System.out.println("测试初始化");
    }

    @Test
    public void testAdd(){
        Calculator c = new Calculator();
        int result = c.add(1, 2);
        Assert.assertEquals(3,result);
    }

    @Test
    public void testSub(){
        Calculator c = new Calculator();
        int result = c.sub(1, 2);
        Assert.assertEquals(-1,result);
    }



    @After
    public void after(){
        System.out.println("测试完成后");
    }

    @AfterClass
    public static void last() {
        System.out.println("Last");
    }

}
