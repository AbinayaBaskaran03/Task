package com.MultipleRow.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.MultipleRow.Entity.Gender;
import com.MultipleRow.Entity.RowEntity;
import com.MultipleRow.Repository.RowRepo;

@Service
public class RowService {

	@Autowired
	private RowRepo rowRepo;

	@Autowired
	private JdbcTemplate jdbc;

	private static final String QUERY = "SELECT * FROM tb_multirow LIMIT 5";

	public void createRecord(RowEntity row) {
		rowRepo.save(row);
	}


	public List<RowEntity> getFirst5Rows() {
		return jdbc.query(QUERY, new RowMapper<RowEntity>() {
			
			@Override
			public RowEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
				RowEntity rowEntity = new RowEntity();
				  rowEntity.setId(UUID.fromString(rs.getString("id")));
	                rowEntity.setName(rs.getString("name"));
	                rowEntity.setAge(rs.getInt("age"));
	                rowEntity.setGender(Gender.valueOf(rs.getString("gender")));
	                rowEntity.setEmailId(rs.getString("email"));
	                rowEntity.setMobileNo(rs.getString("mobile_no"));
	                rowEntity.setAddress(rs.getString("address"));
	                return rowEntity;
			}
		});
	}

}
