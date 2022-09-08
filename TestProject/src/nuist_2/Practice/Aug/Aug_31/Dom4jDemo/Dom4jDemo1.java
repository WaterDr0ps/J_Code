package nuist_2.Practice.Aug.Aug_31.Dom4jDemo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
public class Dom4jDemo1 {
    public static void main(String[] args) throws DocumentException {
        /**
         * XML文档解析
         */
        //创建框架
        SAXReader saxReader=new SAXReader();
        //整个文档
        Document documents=saxReader.read(Dom4jDemo1.class.getResourceAsStream("/xmlDemo.xml"));
        //根元素
        Element root=documents.getRootElement();
        //将子元素添加集合
        List<Element> sonElements = root.elements("student");
        //创建新集合用于存储数据
        List<Students> allInfo = new ArrayList<>();
        //遍历子元素,新建对象去存储
        for (Element sonElement : sonElements) {
            Students stu=new Students();
            stu.setId(sonElement.attributeValue("id"));
            stu.setName(sonElement.elementTextTrim("name"));
            //新对象添加集合
            allInfo.add(stu);
        }
        //遍历
        for (Students students : allInfo) {
            System.out.println(students);
        }


    }
}
