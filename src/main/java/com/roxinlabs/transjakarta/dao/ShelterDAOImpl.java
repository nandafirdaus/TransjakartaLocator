package com.roxinlabs.transjakarta.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.roxinlabs.transjakarta.model.Shelter;

public class ShelterDAOImpl implements ShelterDAO {

	private JdbcTemplate jdbcTemplate;
	
	public ShelterDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void saveOrUpdate(Shelter shelter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int shelterId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Shelter get(int shelterID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Shelter> list() {
		String sql = "SELECT * FROM shelters";
		
		List<Shelter> listShelter = jdbcTemplate.query(sql, new RowMapper<Shelter>() {

			@Override
			public Shelter mapRow(ResultSet rs, int rowNum) throws SQLException {
				Shelter aShelter = new Shelter();
				
				aShelter.setID(rs.getInt("id"));
				aShelter.setName(rs.getString("name"));
				aShelter.setLatitude(rs.getInt("latitude"));
				aShelter.setLongitude(rs.getInt("longitude"));
				
				return aShelter;
			}
		});
		
		return listShelter;
	}

}
