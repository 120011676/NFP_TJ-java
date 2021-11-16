/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.github.qq120011676.nfptj;

import com.github.qq120011676.nfptj.enums.VehiclePlateColorCodeENum;
import com.github.qq120011676.nfptj.ro.DriverRO;
import com.github.qq120011676.nfptj.ro.VehicleRO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;

class NFPTJTest {
    String userId = "1158";
    String password = "bwzppo7yj4";
    String publicKey = "3059301306072a8648ce3d020106082a811ccf5501822d03420004f228e9d80fe12e628d9e8106d9a6c236eaa63d00ae47888bc3217ceb7002953cd458eccbdc6f75aacb9c21e84689b6b0b9b2d79b9c96efeba5dca2e9998873ce";
    String baseUrl = "http://218.67.246.252:6999";

    @Test
    void applyTokenTest() {
        NFPTJ nfptj = new NFPTJ(userId, password, publicKey, baseUrl);
        Assertions.assertNotNull(nfptj.applyToken(), "测试【获取令牌】接口失败");
    }

    @Test
    void driverTest() throws JAXBException, IOException {
        DriverRO ro = new DriverRO();
        ro.setBodys(new ArrayList<>());
        DriverRO.Body body = new DriverRO.Body();
        ro.getBodys().add(body);
        body.setDriverName("姓名");
        body.setDrivingLicense("012345678901234567");
        body.setVehicleClass("A1");
        body.setIssuingOrganizations("驾驶证发证机关");
        body.setValidPeriodFrom("20000101");
        body.setValidPeriodTo("29991231");
        body.setQualificationCertificate("abc");
        body.setTelephone("15812345678");
        body.setRemark("备注");
        NFPTJ nfptj = new NFPTJ(userId, password, publicKey, baseUrl);
        Assertions.assertTrue(nfptj.driver(ro), "测试发送【驾驶员信息】失败");
    }

    @Test
    void vehicleTest() throws JAXBException, IOException {
        VehicleRO ro = new VehicleRO();
        ro.setBodys(new ArrayList<>());
        VehicleRO.Body body = new VehicleRO.Body();
        ro.getBodys().add(body);
        body.setVehicleNumber("津A12345");
        body.setVehiclePlateColorCode(VehiclePlateColorCodeENum.valueOf("绿色").getValue());
        NFPTJ nfptj = new NFPTJ(userId, password, publicKey, baseUrl);
        Assertions.assertTrue(nfptj.vehicle(ro), "测试发送【驾驶员信息】失败");
    }
}
