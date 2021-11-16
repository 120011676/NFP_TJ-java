package com.github.qq120011676.nfptj;

import cn.hutool.core.util.XmlUtil;
import com.github.qq120011676.nfptj.ro.DriverRO;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;

public class XMLTest {
    public static void main(String[] args) throws JAXBException, IOException {
        DriverRO ro = new DriverRO();
        ro.setBodys(new ArrayList<>());
        DriverRO.Body body = new DriverRO.Body();
        ro.getBodys().add(body);
        body.setRemark("a");
        DriverRO.Body body1 = new DriverRO.Body();
        ro.getBodys().add(body1);
        body1.setRemark("b");
        String r = XmlUtil.toStr(XmlUtil.beanToXml(ro));
        System.out.println(r);

        JAXBContext jaxbContext = JAXBContext.newInstance(DriverRO.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        try (StringWriter stringWriter = new StringWriter()) {
            marshaller.marshal(ro, stringWriter);
            stringWriter.flush();
            System.out.println(stringWriter);
        }
    }
}
