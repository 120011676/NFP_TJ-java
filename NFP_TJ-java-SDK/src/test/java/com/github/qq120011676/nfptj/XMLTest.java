package com.github.qq120011676.nfptj;

import cn.hutool.core.util.XmlUtil;
import com.github.qq120011676.nfptj.ro.DriverRO;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;

public class XMLTest {
    public static void main(String[] args) throws JAXBException, IOException {
        DriverRO ro = new DriverRO();
        ro.setRemark("a");
        String r = XmlUtil.toStr(XmlUtil.beanToXml(ro));
        System.out.println(r);

        JAXBContext jaxbContext = JAXBContext.newInstance(DriverRO.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        try (StringWriter stringWriter = new StringWriter()) {
            marshaller.marshal(ro, stringWriter);
            stringWriter.flush();
            System.out.println(stringWriter);
        }
    }
}
