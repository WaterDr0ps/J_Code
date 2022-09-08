package nuist_2.Practice.Aug.Aug_31.Dom4jDemo;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * @author Administrator
 */
public class XpathDemo {
    public static void main(String[] args) throws DocumentException {
        /**
         * 绝对路径
         */
        SAXReader saxReader=new SAXReader();
        Document document = saxReader.read(XpathDemo.class.getResourceAsStream("/xmlDemo.xml"));
        List<Node> nodes = document.selectNodes("/students/student/name");
        for (Node node : nodes) {
            Element nameEle=(Element) node;
            System.out.println(nameEle.getTextTrim());
        }

        System.out.println("--------------------------");
        /**
         * 相对路径 '.'代表当前元素
         */
        SAXReader saxReader1=new SAXReader();
        Document document1 = saxReader1.read(XpathDemo.class.getResourceAsStream("/xmlDemo.xml"));
        Element rootElement = document1.getRootElement();
        List<Node> nodes1 = rootElement.selectNodes("./student/name");
        for (Node node : nodes1) {
            Element nameEle1=(Element) node;
            System.out.println(nameEle1.getTextTrim());
        }

        System.out.println("--------------------------");
        /**
         * 全文查找
         */
        SAXReader saxReader2=new SAXReader();
        Document document2 = saxReader2.read(XpathDemo.class.getResourceAsStream("/xmlDemo.xml"));
        List<Node> nodes2 = document2.selectNodes("//students/student//name");
        for (Node node : nodes2) {
            Element nameEle2=(Element) node;
            System.out.println(nameEle2.getTextTrim());
        }

        System.out.println("--------------------------");
        /**
         * 属性查找
         */
        SAXReader saxReader3=new SAXReader();
        Document document3 = saxReader3.read(XpathDemo.class.getResourceAsStream("/xmlDemo.xml"));
        List<Node> nodes3 = document3.selectNodes("//@id");
        for (Node node : nodes3) {
            Attribute nameEle3=(Attribute) node;
            System.out.println(nameEle3.getName()+"---->>"+nameEle3.getValue());
        }

    }
}
