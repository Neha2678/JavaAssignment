package com.example.MiniProject.trade;

import javax.sql.DataSource;

import com.example.MiniProject.ds.*;
public class TokyoDao extends RegionalDao {

	@Override
	public DataSource getDataSource() {
		return new SqlServerDataSource();
	}

}
