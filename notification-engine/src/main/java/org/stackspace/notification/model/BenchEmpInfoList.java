package org.stackspace.notification.model;

import java.util.List;

public class BenchEmpInfoList {

	private List<BenchEmployeeInfo> benchEmpInfos;

	public List<BenchEmployeeInfo> getBenchEmpInfos() {
		return benchEmpInfos;
	}

	public void setBenchEmpInfos(List<BenchEmployeeInfo> benchEmpInfos) {
		this.benchEmpInfos = benchEmpInfos;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BenchEmpInfoList [benchEmpInfos=").append(benchEmpInfos).append("]");
		return builder.toString();
	}

}
