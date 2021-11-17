package com.github.qq120011676.nfptj.ro;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

/*
 * 电子运单
 */
@Data
@XmlRootElement(name = "Root")
@XmlAccessorType(XmlAccessType.FIELD)
public class WaybillRO {
    @XmlElement(name = "Body")
    private List<Body> bodys;

    @Data
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Body {
        @XmlElement(name = "OriginalDocumentNumber")
        private String originalDocumentNumber;//原始单号（必填，上游企业委托运输单号。）an..35
        @XmlElement(name = "ShippingNoteNumber")
        private String shippingNoteNumber;//运单号（必填，运单号。）an..20
        @XmlElement(name = "VehicleAmount")
        private Integer vehicleAmount;//运输总车辆数（必填，同一运单号的货物总共 使用的运输车辆总数）n..4
        @XmlElement(name = "SerialNumber")
        private String serialNumber;//分段分单号（必填，分段运输和多车运输由 四位数字组成， 前两位代表一 单多车的序号，后两位代表分 段序号。若运输形式为一单一 车填 0000。）an..4
        @XmlElement(name = "TransportTypeCode")
        private Integer transportTypeCode;//运输组织类型代码（必填。）n..2
        @XmlElement(name = "SendToProDateTime")
        private String sendToProDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));//运单上传时间（必填，网络货运经营者上传运 单到省级监测系统的时间， YYYYMMDDhhmmss。）n14
        @XmlElement(name = "Carrier")
        private String carrier;//网络货运经营者名称（必填。）an..512
        @XmlElement(name = "UnifiedSocialCreditIdentifier")
        private String unifiedSocialCreditIdentifier;//统一社会信用代码（必填。）an18
        @XmlElement(name = "PermitNumber")
        private String permitNumber;//道路运输经营许可证编号（必填，网络货运经营者的道路运输经营许可证编号。）an..50
        @XmlElement(name = "ConsignmentDateTime")
        private String consignmentDateTime;//运单生成时间（必填，网络货运经营者信息系统正式成交生成运单的日期时 间。YYYYMMDDhhmmss）n14
        @XmlElement(name = "BusinessTypeCode")
        private String businessTypeCode;//业务类型代码（必填,参考本文文末代码集。）an..7
        @XmlElement(name = "DespatchActualDateTime")
        private String despatchActualDateTime;//发货日期时间（必填，本单货物的发货时间 。YYYYMMDDhhmmss）n14
        @XmlElement(name = "GoodsReceiptDateTime")
        private String goodsReceiptDateTime;//收货日期时间（必填，本单货物的收货时间 YYYYMMDDhhmmss 。）n14
        @XmlElement(name = "ConsignorInfo")
        private List<ConsignorInfoRO> consignorInfos;//托运人信息、收货方信息
        @XmlElement(name = "TotalMonetaryAmount")
        private String totalMonetaryAmount;//运费金额（必填，托运人与网络货运经营 者签订运输合同确定的运费金 额，货币单位为人民币(元) ，保留 3 位小数，如整数的话 ，以.000 填充。如是一笔业务 分几辆车运，需将托运人针对 这笔业务付给网络货运经营者 的运输费用分摊到每辆车上。）n..18,3
        @XmlElement(name = "TransportationCost")
        private String transportationCost;//运输费用（必填。油卡路桥费用等(运输过 程中非人力成本)，货币单位为 人民币(元)，保留3位小数， 如整数的话，以.000填充。）n..18,3
        @XmlElement(name = "TransportationDistance")
        private String transportationDistance;//运输里程（必填。运输的总里程数，单位为 公里。）n..18
        @XmlElement(name = "FinishDateTime")
        private String finishDateTime;//运单完结时间（必填，网络货运经营者在收 货人确认收货后，全部完成该 笔运单的时间YYYYMMDDhhmmss。）n14
        @XmlElement(name = "VehicleInfo")
        private VehicleInfoRO vehicleInfo;//车辆信息
        @XmlElement(name = "ActualCarrierInfo")
        private ActualCarrierInfoRO actualCarrierInfo;//实际承运人信息
        @XmlElement(name = "InsuranceInformation")
        private InsuranceInformationRO insuranceInformation;//保险信息(必填。）
        @XmlElement(name = "Remark")
        private String remark;//备注（选填。）an..256

        /**
         * 运输组织类型代码
         */
        public enum TransportTypeCodeEnum {
            HIGHWAY(1, "公路运输"),
            HIGHWAY_RAILWAY(2, "公铁联运"),
            HIGHWAY_WATERWAY(3, "公水联运"),
            HIGHWAY_AVIATION(4, "公空联运"),
            HIGHWAY_RAILWAY_WATERWAY(5, "公铁水联运"),
            HIGHWAY_RAILWAY_AVIATION(6, "公铁空联运"),
            HIGHWAY_WATERWAY_AVIATION(7, "公水空联运"),
            HIGHWAY_RAILWAY_WATERWAY_AVIATION(8, "公铁水空联运"),
            ;
            private final int value;
            private final String name;

            TransportTypeCodeEnum(int value, String name) {
                this.value = value;
                this.name = name;
            }

            public int getValue() {
                return value;
            }

            public String getName() {
                return name;
            }

            public static TransportTypeCodeEnum parse(String nameOrValue) {
                TransportTypeCodeEnum[] enums = values();
                for (TransportTypeCodeEnum en : enums) {
                    if (Objects.equals(en.getValue() + "", nameOrValue) || Objects.equals(en.getName(), nameOrValue)) {
                        return en;
                    }
                }
                return null;
            }

            public static TransportTypeCodeEnum parse(int value) {
                TransportTypeCodeEnum[] enums = values();
                for (TransportTypeCodeEnum en : enums) {
                    if (Objects.equals(en.getValue(), value)) {
                        return en;
                    }
                }
                return null;
            }
        }

        /**
         * 业务类型代码
         */
        public enum BusinessTypeCodeEnum {
            TRUNK_GENERAL_CARGO_TRANSPORTATION("1002996", "干线普货运输"),//干线普货运输服务
            URBAN_DISTRIBUTION("1003997", "城市配送"),//在城市范围内进行配送
            RURAL_DISTRIBUTION("1003998", "农村配送"),//若发货方或收货方在农村地区即为农村物流
            CONTAINER_TRANSPORT("1002998", "集装箱运输"),//集装箱运输
            OTHER("1003999", "其他"),//其他
            ;
            private final String value;
            private final String name;

            BusinessTypeCodeEnum(String value, String name) {
                this.value = value;
                this.name = name;
            }

            public String getValue() {
                return value;
            }

            public String getName() {
                return name;
            }

            public static BusinessTypeCodeEnum parse(String nameOrValue) {
                BusinessTypeCodeEnum[] enums = values();
                for (BusinessTypeCodeEnum en : enums) {
                    if (Objects.equals(en.getValue(), nameOrValue) || Objects.equals(en.getName(), nameOrValue)) {
                        return en;
                    }
                }
                return null;
            }
        }

        @Data
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class ConsignorInfoRO {
            @XmlElement(name = "Consignor")
            private String consignor;//托运人名称（必填。）an..512
            @XmlElement(name = "ConsignorID")
            private String consignorID;//托运人统一社会信用代码或个人证件号（必填。）an..35
            @XmlElement(name = "PlaceOfLoading")
            private String placeOfLoading;//装货地址（必填，本单货物的装货的地点。）an..256
            @XmlElement(name = "CountrySubdivisionCode")
            private String countrySubdivisionCode;//装货地点的国家行政区划代码（必填，参考本文文末代码集。）an..12

        }

        @Data
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class ConsigneeInfoRO {
            @XmlElement(name = "Consignor")
            private String consignor;//收货方名称（必填。）an..512
            @XmlElement(name = "ConsigneeID")
            private String consigneeID;//收货方统一社会信用代码或个人证件号码（选填。）an..35
            @XmlElement(name = "GoodsReceiptPlace")
            private String goodsReceiptPlace;//收货地址（必填，本单货物的收货的地点。）an..256
            @XmlElement(name = "CountrySubdivisionCode")
            private String countrySubdivisionCode;//收货地点的国家行政区划代码或国别代码（必填，参考本文文末代码集。）an..12
        }

        @Data
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class VehicleInfoRO {
            @XmlElement(name = "VehiclePlateColorCode")
            private String vehiclePlateColorCode;//车牌颜色代码（必填, 参考本文文末代码集。）an..2
            @XmlElement(name = "VehicleNumber")
            private String vehicleNumber;//车辆牌照号（必填。）an..35
            @XmlElement(name = "DespatchActualDateTime")
            private String despatchActualDateTime;//发货日期时间（如果为分段运输必填，本车的 发货时间 YYYYMMDDhhmmss）n14
            @XmlElement(name = "GoodsReceiptDateTime")
            private String goodsReceiptDateTime;//收货日期时间（如果为分段运输必填，本车的 收货时间 YYYYMMDDhhmmss）n14
            @XmlElement(name = "PlaceOfLoading")
            private String placeOfLoading;//装货地址（如果为分段运输必填，本车的 装货的地点。）an..256
            @XmlElement(name = "LoadingCountrySubdivisionCode")
            private String loadingCountrySubdivisionCode;//装货地址的国家行政 x`区划代码或国别代码（如果为分段运输必填, 参考本文 文末代码集。）an..12
            @XmlElement(name = "GoodsReceiptPlace")
            private String goodsReceiptPlace;//收货地址（如果为分段运输必填，本车拉 货终点。）an..256
            @XmlElement(name = "ReceiptCountrySubdivisionCode")
            private String receiptCountrySubdivisionCode;//收货地址的国家行政区划代码或国别代码（如果为分段运输必填, 参考本文 文末代码集。）an..12
            @XmlElement(name = "Driver")
            private List<DriverRO> drivers;//驾驶员（必填，如运输过程中有多个驾 驶员，可循环。）
            @XmlElement(name = "GoodsInfo")
            private List<GoodsInfoRO> goodsInfos;//货物信息（如一车货有不同货物，则可循环。）

            @Data
            @XmlAccessorType(XmlAccessType.FIELD)
            public static class DriverRO {
                @XmlElement(name = "DriverName")
                private String driverName;//姓名（必填。）an..30
                @XmlElement(name = "DrivingLicense")
                private String drivingLicense;//身份证号（必填。）an..18
            }

            @Data
            @XmlAccessorType(XmlAccessType.FIELD)
            public static class GoodsInfoRO {
                @XmlElement(name = "DescriptionOfGoods")
                private String descriptionOfGoods;//货物名称（必填。）an..512
                @XmlElement(name = "CargoTypeClassificationCode")
                private String cargoTypeClassificationCode;//货物类型 分类代码（必填, 参考本文文末代码集。）an4
                @XmlElement(name = "GoodsItemGrossWeight")
                private String goodsItemGrossWeight;//货物项毛重（必填，重量单位以 KGM 千克 填写数值，保留 3 位小数，如 整数的话，以.000 填充。小数 点不计入总长。如是轻泡货等 货物，请估算重量。如一笔业 务分几辆车运，需报送每辆车 实际运输的货物重量。）n..14,3
                @XmlElement(name = "Cube")
                private String cube;//体积（选填，可以为空，有值时要大于0且保留 4 位以 DMQ位小数，体积单如整数的话，以数点不计入总长。）n..9,4
                @XmlElement(name = "TotalNumberOfPackages")
                private Integer totalNumberOfPackages;//总件数（选填，可以为空，有值时要为大于0的整数。）n..8
            }
        }

        @Data
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class ActualCarrierInfoRO {
            @XmlElement(name = "ActualCarrierName")
            private String actualCarrierName;//实际承运人名称（必填，与网络货运经营者签订 运输合同，实际完成运输的经 营者。 取得道路运输经营许可证的个 体运输业户，直接填写“许可证 上的业户名称”; 其他情况填写“运输公司名称 (实际承运驾驶员姓名)”。）an..256
            @XmlElement(name = "ActualCarrierBusinessLicense")
            private String actualCarrierBusinessLicense;//实际承运人道路运输经营许可证号（必填，实际承运人的道路运输 经营许可证编号，网络货运经 营者整合车辆全部为总质量 4.5 吨及以下普通货运车辆的，可 填“车籍地 6 位行政区域代码 +000000”。）an..50
            @XmlElement(name = "ActualCarrierID")
            private String actualCarrierID;//实际承运人统一社会信用代码或证件号码（必填。）an..50
        }

        @Data
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class InsuranceInformationRO {
            @XmlElement(name = "PolicyNumber")
            private String policyNumber;//保险单号（必填，未投保的，可填 none。）an..30
            @XmlElement(name = "InsuranceCompanyCode")
            private String insuranceCompanyCode;//保险公司代码（必填，参见代码集，未投保的 可填“none”。）an..30
        }

    }

}
