package com.github.qq120011676.nfptj.ro;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * 车辆信息
 */
@Data
@XmlRootElement(name = "Root")
@XmlAccessorType(XmlAccessType.FIELD)
public class VehicleRO {
    @XmlElement(name = "Body")
    private List<VehicleRO.Body> bodys;

    @Data
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Body {
        @XmlElement(name = "VehicleNumber")
        private String vehicleNumber;//车辆牌照号（必填。）an..35
        @XmlElement(name = "VehiclePlateColorCode")
        private String vehiclePlateColorCode;//车牌颜色代码（必填。）an..2
        @XmlElement(name = "VehicleType")
        private String vehicleType;//车辆类型代码（必填, 参考本文文末代码集。）an..3
        @XmlElement(name = "Owner")
        private String owner;//所有人（总质量 4.5 吨及以下普通货运车辆 必填，按照机动车行驶证填写。）an..128
        @XmlElement(name = "UseCharacter")
        private String useCharacter;//使用性质（总质量 4.5 吨及以下普通货运车辆 必填，按照机动车行驶证填写。）an..20
        @XmlElement(name = "UseCharacter")
        private String vin;//车辆识别代号（总质量 4.5 吨及以下普通货运车辆 必填，按照机动车行驶证填写。）an..32
        @XmlElement(name = "IssuingOrganizations")
        private String issuingOrganizations;//发证机关（总质量 4.5 吨及以下普通货运车辆 必填，按照机动车行驶证填写。）an..128
        @XmlElement(name = "RegisterDate")
        private String registerDate;//注册日期（总质量 4.5 吨及以下普通货运车辆 必填，按照机动车行驶证填写。 YYYYMMDD）n8
        @XmlElement(name = "IssueDate")
        private String issueDate;//发证日期（总质量 4.5 吨及以下普通货运车辆 必填，按照机动车行驶证填写。 YYYYMMDD）n8
        @XmlElement(name = "VehicleEnergyType")
        private String vehicleEnergyType;//车辆能源类型（必填, 参考本文文末代码集。）an..12
        @XmlElement(name = "VehicleTonnage")
        private String vehicleTonnage;//核定载质量（必填，参考机动车行驶证填写， 默认单位:吨，保留两位小数， 如整数的话，以.00 填充。小数点 不计入总长。）n..9,2
        @XmlElement(name = "GrossMass")
        private String grossMass;//吨位（必填，参考机动车行驶证填写， 默认单位:吨，保留两位小数， 如整数的话，以.00 填充。小数点 不计入总长。）n..9,2
        @XmlElement(name = "RoadTransportCertificateNumber")
        private String roadTransportCertificateNumber;//道路运输证号（必填，总质量 4.5 吨及以下普通货 运车辆的，可填“车籍地 6 位行政 区域代码+000000”。）an..20
        @XmlElement(name = "TrailerVehiclePlateNumber")
        private String trailerVehiclePlateNumber;//挂车牌照号（选填。）an..35
        @XmlElement(name = "Remark")
        private String remark;//备注（选填。）an..256
    }
}
