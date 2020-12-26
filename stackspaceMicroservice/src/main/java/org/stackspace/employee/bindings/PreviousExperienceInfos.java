package org.stackspace.employee.bindings;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.stackspace.employee.entity.PreviousExperienceInfo;

@XmlRootElement(name = "PreviousExperienceInfos")
@XmlAccessorType(XmlAccessType.FIELD)
public class PreviousExperienceInfos {

	@XmlElement(name = "PreviousExperienceInfo")
	private List<PreviousExperienceInfo> experienceInfos;

	public List<PreviousExperienceInfo> getExperienceInfos() {
		return experienceInfos;
	}

	public void setExperienceInfos(List<PreviousExperienceInfo> experienceInfos) {
		this.experienceInfos = experienceInfos;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PreviousExperienceInfos [experienceInfos=").append(experienceInfos).append("]");
		return builder.toString();
	}

}
