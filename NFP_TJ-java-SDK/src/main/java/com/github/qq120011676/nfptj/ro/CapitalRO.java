package com.github.qq120011676.nfptj.ro;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * 资金流水单
 */
@Data
@XmlRootElement(name = "Root")
@XmlAccessorType(XmlAccessType.FIELD)
public class CapitalRO {
    @XmlElement(name = "Body")
    private List<Body> bodys;

    @Data
    @XmlAccessorType(XmlAccessType.FIELD)
    public class Body {
        @XmlElement(name = "DocumentNumber")
        private String documentNumber;//单证号（必填， 本资金流水单 号。）an..35
        @XmlElement(name = "SendToProDateTime")
        private String sendToProDateTime;//资金流水单上传时间（必填，本资金流水单 上传到省级监测系统 的时间。）an..14
        @XmlElement(name = "Carrier")
        private String carrier;//实际承运人名称（必填。）an..512
        @XmlElement(name = "ActualCarrierID")
        private String actualCarrierID;//实际承运人统一社会信用代码或证件号码（必填。）an..50
        @XmlElement(name = "VehicleNumber")
        private String vehicleNumber;//车辆牌照号（必填。）an..35
        @XmlElement(name = "VehiclePlateColorCode")
        private String vehiclePlateColorCode;//车牌颜色代码（必填。）n..2
        @XmlElement(name = "ShippingNoteList")
        private List<ShippingNoteRO> shippingNoteList;//运单列表（必填。）n..2
        @XmlElement(name = "Financiallist")
        private List<FinancialRO> financiallist;//财务列表（必填。）1..n
        @XmlElement(name = "Remark")
        private String remark;//备注（选填。）an..256

        @Data
        @XmlAccessorType(XmlAccessType.FIELD)
        public class ShippingNoteRO {
            @XmlElement(name = "ShippingNoteNumber")
            private String shippingNoteNumber;//托运单号（必填。）an..20
            @XmlElement(name = "SerialNumber")
            private String serialNumber;//分段分单号（必填。）an..4
            @XmlElement(name = "TotalMonetaryAmount")
            private String totalMonetaryAmount;//总金额（该笔运输实际发生费用，含燃油、路桥费 和实际支付金额。）n..18,3
        }

        @Data
        @XmlAccessorType(XmlAccessType.FIELD)
        public class FinancialRO {
            @XmlElement(name = "PaymentMeansCode")
            private String paymentMeansCode;//付款方式代码（必填,参考本文文末代 码集。）an..3
            @XmlElement(name = "Recipient")
            private String recipient;//收款方名称（必填。）an..512
            @XmlElement(name = "ReceiptAccount")
            private String receiptAccount;//收款帐户信息（必填，银行卡号或其 他收款帐号。）an..512
            @XmlElement(name = "BankCode")
            private String bankCode;//收款方银行代码（选填, 参考本文文末代 码集。）an..11
            @XmlElement(name = "SequenceCode")
            private String sequenceCode;//流水号/序列号（必填，银行或第三方 支付平台的资金流水 单号，现金等其他方 式可填财务记账号。）an..50
            @XmlElement(name = "MonetaryAmount")
            private String monetaryAmount;//实际支付金额（必填，资金流水金额 ，货币单位为人民币 ，保留 3位小数， 如整数的话， 以.000 填充。）n..18,3
            @XmlElement(name = "DateTime")
            private String dateTime;//日期时间（资金流水实际发生时 间。 YYYYMMDDhhmmss）n14
        }

    }

}
