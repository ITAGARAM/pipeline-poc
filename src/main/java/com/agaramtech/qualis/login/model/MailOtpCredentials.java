package com.agaramtech.qualis.login.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;

import org.apache.commons.text.StringEscapeUtils;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.jdbc.core.RowMapper;

import com.agaramtech.qualis.global.CustomizedResultsetRowMapper;
import com.agaramtech.qualis.global.Enumeration;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * This class is used to map the fields of 'unit' table of the Database.
 */
@Entity
@Table(name = "mailotpcredentials")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MailOtpCredentials extends CustomizedResultsetRowMapper<MailOtpCredentials> implements Serializable,RowMapper<MailOtpCredentials> {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "nmailotpcredentialscode")
	private int nmailotpcredentialscode;

	@Column(name = "sreferenceid", length=100, nullable = false)
	private String sreferenceid;
	
	@Column(name = "sotp", length=10, nullable = false)
	private String sotp;
	@Column(name = "dmodifieddate", nullable = false)
	private Instant dmodifieddate;

	
	
	@Column(name = "dcreateddate", nullable = false)
	private Instant dcreateddate;

	
	@ColumnDefault("-1")
	@Column(name = "nsitecode", nullable = false)
	private short nsitecode=(short)Enumeration.TransactionStatus.NA.gettransactionstatus();

	@ColumnDefault("1")
	@Column(name = "nstatus", nullable = false)
	private short nstatus=(short)Enumeration.TransactionStatus.ACTIVE.gettransactionstatus();	
	
	
	
	@Override
	public MailOtpCredentials mapRow(ResultSet arg0, int arg1) throws SQLException {
		
		final MailOtpCredentials objUsersotpCredentials = new MailOtpCredentials();
		
		objUsersotpCredentials.setNmailotpcredentialscode(getInteger(arg0,"nmailotpcredentialscode",arg1));
		objUsersotpCredentials.setSreferenceid(StringEscapeUtils.unescapeJava(getString(arg0,"sreferenceid",arg1)));
		objUsersotpCredentials.setSotp(StringEscapeUtils.unescapeJava(getString(arg0,"sotp",arg1)));
		objUsersotpCredentials.setNsitecode(getShort(arg0,"nsitecode",arg1));
		objUsersotpCredentials.setNstatus(getShort(arg0,"nstatus",arg1));
		objUsersotpCredentials.setDmodifieddate(getInstant(arg0,"dmodifieddate",arg1));
		objUsersotpCredentials.setDcreateddate(getInstant(arg0,"dcreateddate",arg1));

		
		return objUsersotpCredentials;
	}

}