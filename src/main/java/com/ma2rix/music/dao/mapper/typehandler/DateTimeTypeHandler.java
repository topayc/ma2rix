package com.ma2rix.music.dao.mapper.typehandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.sql.*;

/**
 * MySql Timestamp 과 자바의 Datetime 를 변한하기 위한 타입 핸들러 
 * 프레임워크 내부에서 사용되기 때문에 메서드 주석 생략함 
 *
 */
@MappedTypes(DateTime.class)
public class DateTimeTypeHandler implements TypeHandler {

	public void setParameter(PreparedStatement ps, int i, Object parameter,
			JdbcType jdbcType) throws SQLException {
		if (parameter != null) {
			ps.setTimestamp(i,
					new Timestamp(((DateTime) parameter).getMillis()));
		} else {
			ps.setTimestamp(i, null);
		}
	}

	public Object getResult(ResultSet rs, String columnName)
			throws SQLException {
		Timestamp ts = rs.getTimestamp(columnName);
		if (ts != null) {
			return new DateTime(ts.getTime(), DateTimeZone.UTC);
		} else {
			return null;
		}
	}

	public Object getResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		Timestamp ts = cs.getTimestamp(columnIndex);
		if (ts != null) {
			return new DateTime(ts.getTime(), DateTimeZone.UTC);
		} else {
			return null;
		}
	}
}