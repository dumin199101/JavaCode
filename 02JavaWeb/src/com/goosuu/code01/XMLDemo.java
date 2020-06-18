package com.goosuu.code01;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *   XML:
 *     了解：
 *       XML构成
 *         XML声明：
 *          <?xml 属性 ?>
 *          属性：
 *            version
 *            encoding
 *         XML指令
 *         标签
 *         属性
 *         文本:<![CDATA[数据]]>包含数据不会被转义解析
 *  *       XML约束
 *  *         DTD约束:简单
 *  *         Schema约束:复杂
 *  *     重点：
 *      XML解析:
 *        Jsoup工具类
 *           parse()
 *        Element对象：
 *          html():获取标签的所有内容，包括子标签，
 *          text():获取文本内容
 *          attr():根据属性名，获取属性值
 *        Selector选择器：
 *          select()
 *        Xpath语法：
 *          JxDocument(Document doc)
 *          selN(X)
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */


public class XMLDemo {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        String path = XMLDemo.class.getClassLoader().getResource("student.xml").getPath();
        Document doc = Jsoup.parse(new File(path), "utf-8");
        Elements names = doc.getElementsByTag("name");
        System.out.println(names.size());
        Element element = names.get(0);
        System.out.println(element.text());
        Elements elementsByAttributeValue = doc.getElementsByAttributeValue("number", "itcast_0001");
        System.out.println(elementsByAttributeValue.get(0).html());
        System.out.println(elementsByAttributeValue.get(0).attr("number"));
        System.out.println("********************");
        //selector选择器
        Elements select = doc.select("student[number='itcast_0002']");
        System.out.println(select);
        System.out.println("*********************");
        //使用xpath
        JXDocument jxDocument = new JXDocument(doc);
        List<JXNode> jxNodes = jxDocument.selN("//student[@number='itcast_0002']/name");
        for (JXNode jxNode : jxNodes) {
            System.out.println(jxNode);
            Element element1 = jxNode.getElement();
            System.out.println(element1.text());
        }


    }
}
