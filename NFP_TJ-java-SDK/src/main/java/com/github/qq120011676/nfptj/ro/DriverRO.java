package com.github.qq120011676.nfptj.ro;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * 驾驶员信息
 */
@Data
@XmlRootElement(name = "Root")
@XmlAccessorType(XmlAccessType.FIELD)
public class DriverRO {
    @XmlElement(name = "DriverName")
    private String driverName;//姓名（必填，根据机动车驾驶证填写。）an..30
    @XmlElement(name = "DrivingLicense")
    private String drivingLicense;//身份证号（必填，根据机动车驾驶证填写。）an..18
    @XmlElement(name = "VehicleClass")
    private String vehicleClass;//准驾车型（使用总质量 4.5 吨及以下普通货运车 辆从事普通货物运输经营的驾驶员必 填，根据机动车驾驶证填写。）an..20
    @XmlElement(name = "IssuingOrganizations")
    private String issuingOrganizations;//驾驶证发证机关（使用总质量 4.5 吨及以下普通货运车 辆从事普通货物运输经营的驾驶员必 填，根据机动车驾驶证填写。）an..128
    @XmlElement(name = "ValidPeriodFrom")
    private String validPeriodFrom;//驾驶证有效期自（使用总质量 4.5 吨及以下普通货运车 辆从事普通货物运输经营的驾驶员必 填，根据机动车驾驶证填写。 YYYYMMDD）n8
    @XmlElement(name = "ValidPeriodTo")
    private String validPeriodTo;//驾驶证有效期至（使用总质量 4.5 吨及以下普通货运车 辆从事 普通货物运输经营的驾驶员必 填，根据机动车驾驶证填写(如果为长 期填 29991231)。YYYYMMDD）n8
    @XmlElement(name = "QualificationCertificate")
    private String qualificationCertificate;//从业资格证号（必填，驾驶员从业资格证号，使用总质量4.5吨及以下普通货运车辆从事普通h货物运输经营的驾驶员，填写“驾驶员身份证前6位+000000”。）an..19
    @XmlElement(name = "Telephone")
    private String telephone;//手机号码（必填。）an..18
    @XmlElement(name = "Remark")
    private String remark;//备注（选填。）an..256
}
