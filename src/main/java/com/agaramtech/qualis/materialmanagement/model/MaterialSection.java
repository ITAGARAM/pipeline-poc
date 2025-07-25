package com.agaramtech.qualis.materialmanagement.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.Map;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.jdbc.core.RowMapper;

import com.agaramtech.qualis.global.CustomizedResultsetRowMapper;
import com.agaramtech.qualis.global.Enumeration;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "materialsection")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MaterialSection extends CustomizedResultsetRowMapper<MaterialSection> implements Serializable,RowMapper<MaterialSection> {


	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "nmaterialsectioncode")
	private int nmaterialsectioncode;

	@Column(name = "nmaterialcode")
	private int nmaterialcode;

	@Column(name = "nsectioncode")
	private int nsectioncode;
	
	@ColumnDefault("1")
	@Column(name = "nstatus")
	private short nstatus=(short)Enumeration.TransactionStatus.ACTIVE.gettransactionstatus();
	
	@Lob
	@Column(name = "jsondata", columnDefinition = "jsonb")
	private Map<String, Object> jsondata;
	
	@ColumnDefault("-1")
	@Column(name = "nsitecode", nullable = false)
	private short nsitecode=(short)Enumeration.TransactionStatus.NA.gettransactionstatus();
	
	@Column(name="dmodifieddate", nullable = false)
	private Instant dmodifieddate;



	@Override
	public MaterialSection mapRow(ResultSet arg0, int arg1)throws SQLException {
		final MaterialSection objMaterialSection = new MaterialSection();

		objMaterialSection.setNmaterialcode( getInteger( arg0,"nmaterialcode",arg1));
		objMaterialSection.setNmaterialsectioncode( getInteger( arg0,"nmaterialsectioncode",arg1));
		objMaterialSection.setNsectioncode( getInteger( arg0,"nsectioncode",arg1));
		objMaterialSection.setNstatus( getShort( arg0,"nstatus",arg1));
		objMaterialSection.setJsondata(unescapeString( getJsonObject( arg0,"jsondata",arg1)));
		objMaterialSection.setDmodifieddate(getInstant(arg0,"dmodifieddate",arg1));
		objMaterialSection.setNsitecode(getShort(arg0,"nsitecode",arg1));

		return objMaterialSection;
		
	}
}
