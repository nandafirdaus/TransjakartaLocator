package com.roxinlabs.transjakarta.dao;


import java.util.List;

import com.roxinlabs.transjakarta.model.Shelter;

public interface ShelterDAO {
	public void saveOrUpdate(Shelter shelter);
	
	public void delete(int shelterId);
	
	public Shelter get(int shelterID);
	
	public List<Shelter> list();
}
