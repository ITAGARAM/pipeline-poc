package com.agaramtech.qualis.batchcreation.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
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
 * This class is used to map the fields of 'seqnobatchcreation' table of the
 * Database. 
 */

@Entity
@Data
@Table(name = "seqnobatchcreation")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)

public class SeqNoBatchcreation extends CustomizedResultsetRowMapper<SeqNoBatchcreation> implements Serializable, RowMapper<SeqNoBatchcreation> {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "stablename", length = 50, nullable = false)
	private String stablename;

	@Column(name = "nsequenceno", nullable = false)
	private int nsequenceno;

	@Column(name = "nstatus", nullable = false)
	@ColumnDefault("1")
	private short nstatus = (short)Enumeration.TransactionStatus.ACTIVE.gettransactionstatus();
	
	@Override
	public SeqNoBatchcreation mapRow(ResultSet arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		SeqNoBatchcreation objSeqNoBatchcreation = new SeqNoBatchcreation();
		objSeqNoBatchcreation.setStablename(getString(arg0,"stablename",arg1));
		objSeqNoBatchcreation.setNsequenceno(getInteger(arg0,"nsequenceno",arg1));
		objSeqNoBatchcreation.setNstatus(getShort(arg0,"nstatus",arg1));
		return objSeqNoBatchcreation;
	}

}
