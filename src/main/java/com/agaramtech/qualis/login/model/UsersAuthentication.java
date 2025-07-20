package com.agaramtech.qualis.login.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.jdbc.core.RowMapper;

import com.agaramtech.qualis.global.CustomizedResultsetRowMapper;
import com.agaramtech.qualis.global.Enumeration;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * This class is used to map the fields of 'unit' table of the Database.
 */
@Entity
@Table(name = "usersauthentication")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UsersAuthentication extends CustomizedResultsetRowMapper<UsersAuthentication> implements Serializable,RowMapper<UsersAuthentication> {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name = "nusercode", nullable = false)
	private int nusercode;
	
	@Column(name = "nauthenticationtypecode", nullable = false)
	private int nauthenticationtypecode;
	
	@ColumnDefault("3")
	@Column(name = "nactivestatus", nullable = false)
	private short nactivestatus=(short)Enumeration.TransactionStatus.YES.gettransactionstatus();
	
	
	@Column(name = "dmodifieddate", nullable = false)
	private Instant dmodifieddate;

	@ColumnDefault("-1")
	@Column(name = "nsitecode", nullable = false)
	private short nsitecode=(short)Enumeration.TransactionStatus.NA.gettransactionstatus();

	@ColumnDefault("1")
	@Column(name = "nstatus", nullable = false)
	private short nstatus=(short)Enumeration.TransactionStatus.ACTIVE.gettransactionstatus();	
	
	@Transient
	private transient String sauthenticationname;
	
	@Override
	public UsersAuthentication mapRow(ResultSet arg0, int arg1) throws SQLException {
		
		final UsersAuthentication objUsersAuthentication= new UsersAuthentication();
		
		objUsersAuthentication.setNusercode(getInteger(arg0,"nusercode",arg1));
		objUsersAuthentication.setNauthenticationtypecode(getInteger(arg0,"nauthenticationtypecode",arg1));
		objUsersAuthentication.setNactivestatus(getShort(arg0,"nactivestatus",arg1));
		objUsersAuthentication.setNsitecode(getShort(arg0,"nsitecode",arg1));
		objUsersAuthentication.setNstatus(getShort(arg0,"nstatus",arg1));
		objUsersAuthentication.setDmodifieddate(getInstant(arg0,"dmodifieddate",arg1));
		objUsersAuthentication.setSauthenticationname(getString(arg0,"sauthenticationname",arg1));

		
		return objUsersAuthentication;
	}

}