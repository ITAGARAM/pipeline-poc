package com.agaramtech.qualis.reports.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.Map;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.jdbc.core.RowMapper;

import com.agaramtech.qualis.global.CustomizedResultsetRowMapper;
import com.agaramtech.qualis.global.Enumeration;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reporttype")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ReportType extends CustomizedResultsetRowMapper<ReportType> implements Serializable, RowMapper<ReportType> {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "nreporttypecode")
	private short nreporttypecode;
	@Column(name = "isneedregtype", nullable = false)
	private short isneedregtype;
	@Column(name = "sreporttypename", length = 50, nullable = false)
	private String sreporttypename;
	@Lob
	@Column(name = "jsondata", columnDefinition = "jsonb")
	private Map<String, Object> jsondata;
	@Column(name = "nstatus", nullable = false)
	private short nstatus = (short) Enumeration.TransactionStatus.ACTIVE.gettransactionstatus();
	@Column(name = "dmodifieddate")
	private Instant dmodifieddate;

	@Transient
	private transient String sdisplayname;
	@Transient
	private transient String sdefaultname;

	@Override
	public ReportType mapRow(ResultSet arg0, int arg1) throws SQLException {
		ReportType reportTypeObj = new ReportType();
		reportTypeObj.setNreporttypecode(getShort(arg0, "nreporttypecode", arg1));
		reportTypeObj.setIsneedregtype(getShort(arg0, "isneedregtype", arg1));
		reportTypeObj.setSreporttypename(StringEscapeUtils.unescapeJava(getString(arg0, "sreporttypename", arg1)));
		reportTypeObj.setJsondata(unescapeString(getJsonObject(arg0, "jsondata", arg1)));
		reportTypeObj.setNstatus(getShort(arg0, "nstatus", arg1));
		reportTypeObj.setSdisplayname(getString(arg0, "sdisplayname", arg1));
		reportTypeObj.setSdefaultname(getString(arg0, "sdefaultname", arg1));
		reportTypeObj.setDmodifieddate(getInstant(arg0, "dmodifieddate", arg1));
		return reportTypeObj;
	}

}
