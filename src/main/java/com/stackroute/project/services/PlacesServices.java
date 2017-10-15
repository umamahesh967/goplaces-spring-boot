package com.stackroute.project.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stackroute.project.domains.*;
import com.stackroute.project.repository.PlacesRepository;

@Service
public class PlacesServices {
	
	@Autowired
	private PlacesRepository placeRepository;
	
	public List<Places> getAll(){
		List<Places> places=new ArrayList<>();
		placeRepository.findAll().forEach(places::add);
		return places;
	}
	
	public void addPlace(Places place) {
		placeRepository.save(place);
	}
	
	public Places getPlace(String id) {
		return placeRepository.findOne(id);
	}
	
	public void updatePlace(Places place) {
		placeRepository.save(place);
		
	}
	
	public void deletePlace(String id) {
		placeRepository.delete(id);
	}
	
}
