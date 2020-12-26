package org.stackspace.employee.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "stackspace.datasource")
public class PropertyConfigurationBean {

	private String url;

	private String userName;

	private String password;

	private String platform;

	private boolean ddl;

	private boolean showSql;

	private String ddluto;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public boolean isDdl() {
		return ddl;
	}

	public void setDdl(boolean ddl) {
		this.ddl = ddl;
	}

	public boolean isShowSql() {
		return showSql;
	}

	public void setShowSql(boolean showSql) {
		this.showSql = showSql;
	}

	public String getDdluto() {
		return ddluto;
	}

	public void setDdluto(String ddluto) {
		this.ddluto = ddluto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (ddl ? 1231 : 1237);
		result = prime * result + ((ddluto == null) ? 0 : ddluto.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((platform == null) ? 0 : platform.hashCode());
		result = prime * result + (showSql ? 1231 : 1237);
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PropertyConfigurationBean other = (PropertyConfigurationBean) obj;
		if (ddl != other.ddl)
			return false;
		if (ddluto == null) {
			if (other.ddluto != null)
				return false;
		} else if (!ddluto.equals(other.ddluto))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (platform == null) {
			if (other.platform != null)
				return false;
		} else if (!platform.equals(other.platform))
			return false;
		if (showSql != other.showSql)
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	
	
}
