package nl.cwi.da.jdbccts;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Logger;

// some hackery going on here
public class DriverWrapper implements Driver {
	
	static {
		try {
			DriverManager.registerDriver(new DriverWrapper());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection connect(String url, Properties info) throws SQLException {
		Connection conn;
		try {
			conn = ((Driver)Class.forName("org.duckdb.DuckDBDriver").newInstance()).connect("jdbc:duckdb:", null);
		} catch (Exception e) {
			throw new SQLException(e);
		}
		Statement s = conn.createStatement();
		s.executeUpdate("create table ctstable1 (TYPE_ID int, TYPE_DESC varchar(32))");
		s.executeUpdate("create table ctstable2 (KEY_ID int, COF_NAME varchar(32), PRICE float, TYPE_ID int )");
		s.executeUpdate("create table Smallint_Tab (MAX_VAL SMALLINT, MIN_VAL SMALLINT, NULL_VAL SMALLINT NULL)");
		s.executeUpdate("create table Varchar_Tab (COFFEE_NAME VARCHAR(60), NULL_VAL VARCHAR(60) NULL)");
		s.executeUpdate("create table Tinyint_Tab (MAX_VAL SMALLINT, MIN_VAL SMALLINT, NULL_VAL SMALLINT NULL)");
		s.executeUpdate("create table Integer_Tab (MAX_VAL INTEGER, MIN_VAL INTEGER, NULL_VAL INTEGER NULL)");
		s.executeUpdate("create table Real_Tab (MAX_VAL float8, MIN_VAL float8 ,NULL_VAL float8 NULL)");
		s.executeUpdate("create table Float_Tab (MAX_VAL FLOAT8, MIN_VAL FLOAT8, NULL_VAL FLOAT8 NULL)");
		s.executeUpdate("create table Decimal_Tab (MAX_VAL DECIMAL(30,15),MIN_VAL DECIMAL(30,15), NULL_VAL DECIMAL(30,15) NULL) ");
		s.executeUpdate("create table Numeric_Tab (MAX_VAL NUMERIC(30,15), MIN_VAL NUMERIC(30,15), NULL_VAL NUMERIC(30,15) NULL) ");
		s.executeUpdate("create table Char_Tab (COFFEE_NAME CHAR(30), NULL_VAL CHAR(30) NULL) ");
		s.executeUpdate("create table Bit_Tab (MAX_VAL boolean, MIN_VAL boolean, NULL_VAL boolean NULL)");
		s.executeUpdate("create table Double_Tab (MAX_VAL DOUBLE PRECISION, MIN_VAL DOUBLE PRECISION, NULL_VAL DOUBLE PRECISION NULL)");
		s.executeUpdate("create table Bigint_Tab (MAX_VAL bigint, MIN_VAL bigint , NULL_VAL bigint  NULL)");
		s.executeUpdate("create table Longvarchar_Tab (COFFEE_NAME TEXT)");
		s.executeUpdate("create table Longvarcharnull_Tab (NULL_VAL TEXT NULL)");
		s.close();
		return conn;
	}

	public boolean acceptsURL(String url) throws SQLException {
		return url.startsWith("jdbc:wrap:");
	}

	@Override
	public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
		return null;
	}

	@Override
	public int getMajorVersion() {
		return 1;
	}

	@Override
	public int getMinorVersion() {
		return 0;
	}

	@Override
	public boolean jdbcCompliant() {
		return true;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}

}
