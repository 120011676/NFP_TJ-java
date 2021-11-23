/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.github.qq120011676.nfptj;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.github.qq120011676.nfptj.config.NFPTJConfig;
import com.github.qq120011676.nfptj.enums.BusinessTypeCodeEnum;
import com.github.qq120011676.nfptj.enums.TransportTypeCodeEnum;
import com.github.qq120011676.nfptj.enums.VehicleEnergyTypeEnum;
import com.github.qq120011676.nfptj.enums.VehiclePlateColorCodeEnum;
import com.github.qq120011676.nfptj.ro.CapitalRO;
import com.github.qq120011676.nfptj.ro.DriverRO;
import com.github.qq120011676.nfptj.ro.VehicleRO;
import com.github.qq120011676.nfptj.ro.WaybillRO;
import com.github.qq120011676.nfptj.statics.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

class NFPTJTest {
    private final NFPTJ nfptj;

    public NFPTJTest() {
        String userId = "";
        String password = "";
        String publicKey = "";
        String baseUrl = "http://218.67.246.252:6999";

        List<String> lines = FileUtil.readUtf8Lines(Objects.requireNonNull(CountrySubdivisionCodeStatic.class.getResource("/nfp_tj_config.txt")));
        for (String line : lines) {
            if (StrUtil.isBlank(line)) {
                continue;
            }
            String[] nv = line.split("=");
            switch (nv[0]) {
                case "userId":
                    userId = nv[1];
                    break;
                case "password":
                    password = nv[1];
                    break;
                case "publicKey":
                    publicKey = nv[1];
                    break;
            }
        }
        NFPTJConfig nfptjConfig = new NFPTJConfig();
        nfptjConfig.setUserId(userId);
        nfptjConfig.setPassword(password);
        nfptjConfig.setPublicKey(publicKey);
        nfptjConfig.setBaseUrl(baseUrl);
        nfptj = new NFPTJ(nfptjConfig);
    }

    @Test
    void applyTokenTest() {
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
        Assertions.assertTrue(nfptj.driver(ro), "测试发送【驾驶员信息】失败");
    }

    @Test
    void vehicleTest() throws JAXBException, IOException {
        VehicleRO ro = new VehicleRO();
        ro.setBodys(new ArrayList<>());
        VehicleRO.Body body = new VehicleRO.Body();
        ro.getBodys().add(body);
        body.setVehicleNumber("津A12345");
        body.setVehiclePlateColorCode(Objects.requireNonNull(VehiclePlateColorCodeEnum.parse("绿色")).getValue());
        body.setVehicleType(Objects.requireNonNull(VehicleTypeStatic.parseName("重型集装箱车")).getCode());
        body.setOwner("所有人");
        body.setUseCharacter("使用性质");
        body.setVin("车辆识别代号");
        body.setIssuingOrganizations("发证机关");
        body.setRegisterDate("20000101");
        body.setIssueDate("20000101");
        body.setVehicleEnergyType(Objects.requireNonNull(VehicleEnergyTypeEnum.parse("汽油")).getValue());
        body.setVehicleTonnage("30.00");
        body.setGrossMass("30.00");
        body.setRoadTransportCertificateNumber("道路运输证号");
        body.setTrailerVehiclePlateNumber("挂车牌照号");
        body.setRemark("备注");
        Assertions.assertTrue(nfptj.vehicle(ro), "测试发送【车辆信息】失败");
    }

    @Test
    void waybillTest() throws JAXBException, IOException {
        WaybillRO ro = new WaybillRO();
        ro.setBodys(new ArrayList<>());
        WaybillRO.Body body = new WaybillRO.Body();
        ro.getBodys().add(body);
        body.setOriginalDocumentNumber(UUID.randomUUID().toString().replaceAll("-", ""));
        body.setShippingNoteNumber("123");
        body.setVehicleAmount(2);
        body.setSerialNumber("0000");
        body.setTransportTypeCode(Objects.requireNonNull(TransportTypeCodeEnum.parse("公铁水空联运")).getValue());
        body.setSendToProDateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
        body.setCarrier("网络货运经营者名称");
        body.setUnifiedSocialCreditIdentifier("012345678901234567");
        body.setPermitNumber("012345678901234567");
        body.setConsignmentDateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
        body.setBusinessTypeCode(Objects.requireNonNull(BusinessTypeCodeEnum.parse("集装箱运输")).getValue());
        body.setDespatchActualDateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
        body.setGoodsReceiptDateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
        body.setConsignorInfo(new WaybillRO.Body.ConsignorInfoRO());
        body.getConsignorInfo().setConsignor("托运人名称");
        body.getConsignorInfo().setConsignorID("012345678901234567");
        body.getConsignorInfo().setPlaceOfLoading("装货地址");
        body.getConsignorInfo().setCountrySubdivisionCode(Objects.requireNonNull(CountrySubdivisionCodeStatic.parseName("四川")).getCode());
        body.setConsigneeInfo(new WaybillRO.Body.ConsigneeInfoRO());
        body.getConsigneeInfo().setConsignee("收货方名称");
        body.getConsigneeInfo().setConsigneeID("收货方统一社会信用代码或个人证件号码");
        body.getConsigneeInfo().setGoodsReceiptPlace("收货地址");
        body.getConsigneeInfo().setCountrySubdivisionCode(Objects.requireNonNull(CountrySubdivisionCodeStatic.parseName("上海")).getCode());
        body.setTotalMonetaryAmount("10.001");
        body.setTransportationCost("5.001");
        body.setTransportationDistance(2000);
        body.setFinishDateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
        body.setVehicleInfo(new WaybillRO.Body.VehicleInfoRO());
        body.getVehicleInfo().setVehiclePlateColorCode(Objects.requireNonNull(VehiclePlateColorCodeEnum.parse("农黄色")).getValue());
        body.getVehicleInfo().setVehicleNumber("车辆牌照号");
        body.getVehicleInfo().setDespatchActualDateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
        body.getVehicleInfo().setGoodsReceiptDateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
        body.getVehicleInfo().setPlaceOfLoading("装货地址");
        body.getVehicleInfo().setLoadingCountrySubdivisionCode(Objects.requireNonNull(CountrySubdivisionCodeStatic.parseName("四川")).getCode());
        body.getVehicleInfo().setGoodsReceiptPlace("收货地址");
        body.getVehicleInfo().setReceiptCountrySubdivisionCode(Objects.requireNonNull(CountrySubdivisionCodeStatic.parseName("北京")).getCode());
        body.getVehicleInfo().setDrivers(new ArrayList<>());
        WaybillRO.Body.VehicleInfoRO.DriverRO driverRO = new WaybillRO.Body.VehicleInfoRO.DriverRO();
        body.getVehicleInfo().getDrivers().add(driverRO);
        driverRO.setDriverName("姓名");
        driverRO.setDrivingLicense("012345678901234567");
        body.getVehicleInfo().setGoodsInfos(new ArrayList<>());
        WaybillRO.Body.VehicleInfoRO.GoodsInfoRO goodsInfoRO = new WaybillRO.Body.VehicleInfoRO.GoodsInfoRO();
        body.getVehicleInfo().getGoodsInfos().add(goodsInfoRO);
        goodsInfoRO.setDescriptionOfGoods("货物名称");
        goodsInfoRO.setCargoTypeClassificationCode(Objects.requireNonNull(CargoTypeClassificationCodeStatic.parseName("金属矿石")).getCode());
        goodsInfoRO.setGoodsItemGrossWeight("10.001");
        goodsInfoRO.setCube("500.0000");
        goodsInfoRO.setTotalNumberOfPackages(2);
        body.setActualCarrierInfo(new WaybillRO.Body.ActualCarrierInfoRO());
        body.getActualCarrierInfo().setActualCarrierName("实际承运人名称");
        body.getActualCarrierInfo().setActualCarrierBusinessLicense("实际承运人道路运输经营许可证号");
        body.getActualCarrierInfo().setActualCarrierID("实际承运人统一社会信用代码或证件号码");
        body.setInsuranceInformation(new WaybillRO.Body.InsuranceInformationRO());
        body.getInsuranceInformation().setPolicyNumber("none");
        body.getInsuranceInformation().setInsuranceCompanyCode("none");
        body.setRemark("备注");
        Assertions.assertTrue(nfptj.waybill(ro), "测试发送【电子运单】失败");
    }

    @Test
    void capitalTest() throws JAXBException, IOException {
        CapitalRO ro = new CapitalRO();
        ro.setBodys(new ArrayList<>());
        CapitalRO.Body body = new CapitalRO.Body();
        ro.getBodys().add(body);
        body.setDocumentNumber(UUID.randomUUID().toString().replaceAll("-", ""));
        body.setCarrier("实际承运人名称");
        body.setActualCarrierID("012345678901234567");
        body.setVehicleNumber("车辆牌照号");
        body.setVehiclePlateColorCode(Objects.requireNonNull(VehiclePlateColorCodeEnum.parse("农绿色")).getValue());
        body.setShippingNoteList(new ArrayList<>());
        CapitalRO.Body.ShippingNoteRO shippingNoteRO = new CapitalRO.Body.ShippingNoteRO();
        body.getShippingNoteList().add(shippingNoteRO);
        shippingNoteRO.setShippingNoteNumber("134");
        shippingNoteRO.setSerialNumber("0123");
        shippingNoteRO.setTotalMonetaryAmount("3000.001");
        body.setFinanciallist(new ArrayList<>());
        CapitalRO.Body.FinancialRO financialRO = new CapitalRO.Body.FinancialRO();
        body.getFinanciallist().add(financialRO);
        financialRO.setPaymentMeansCode(Objects.requireNonNull(PaymentMeansCodeStatic.parseName("微信支付")).getCode());
        financialRO.setRecipient("收款方名称");
        financialRO.setReceiptAccount("收款帐户信息");
        financialRO.setBankCode(Objects.requireNonNull(BankCodeStatic.parseName("江苏苏宁银行")).getCode());
        financialRO.setSequenceCode(UUID.randomUUID().toString());
        financialRO.setMonetaryAmount("5000.001");
        financialRO.setDateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
        body.setRemark("备注");
        Assertions.assertTrue(nfptj.capital(ro), "测试发送【资金流水单】失败");

    }
}
