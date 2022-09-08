package nuist_2.Practice.Aug.Aug_31.Dom4jDemo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentType;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * @author Administrator
 */
public class Dom4jDemo {
    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader=new SAXReader();
        InputStream is=Dom4jDemo.class.getResourceAsStream("/logback.xml");
        //拿到了整个文档
        Document document = saxReader.read(is);
        //拿到根元素
        Element rootElement = document.getRootElement();

        //所有元素
        List<Element> sonElements = rootElement.elements();
        for (Element sonElement : sonElements) {
            System.out.println(sonElement.getName());
        }
    }
}
