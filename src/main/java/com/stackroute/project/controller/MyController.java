package com.stackroute.project.controller;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stackroute.project.domains.Places;
import com.stackroute.project.services.PlacesServices;



@RestController
@RequestMapping(value="/goplaces")
@Api(value="GoPlaces", description="Operations pertaining to products in Online Store")
public class MyController {
	
	@Autowired
	private PlacesServices placeservice;
	
	@ApiOperation(value = "View a list of available products",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping(value="/list", produces= {"application/json"})
	public ResponseEntity<List<Places>> list(){
		List<Places> places=new ArrayList<>();
		places=placeservice.getAll();
		return new ResponseEntity<List<Places>>(places,HttpStatus.OK);
	}
    

    @ApiOperation(value = "Update a product")
	@PutMapping(value="/update")
	public ResponseEntity<String> update(@RequestBody Places plc){
		String str="User saved successfully";
		placeservice.updatePlace(plc);
		return new ResponseEntity<String>(str,HttpStatus.OK);
	}
	
	
	
	@ApiOperation(value = "Delete a product")
	@DeleteMapping(value="/delete/{id}")
	  public ResponseEntity<String> delete(@RequestBody String id){
		placeservice.deletePlace(id);
		return new ResponseEntity<String>("Deleted Succesfully",HttpStatus.OK);
	}
	
	@PostMapping(value="/add",consumes= {"application/json"})
	@ApiOperation(value = "Add a product")
	public ResponseEntity<String> add(@RequestBody Places plc){
		placeservice.addPlace(plc);
		return new ResponseEntity<String>("Added Succesfully",HttpStatus.OK);
	}
	
	
	@GetMapping(value="/show/{id}", produces= {"application/json"})
	@ApiOperation(value = "Search a product with an ID",response = Places.class)
	public ResponseEntity<Places> getone(@RequestBody String id){
		Places place=placeservice.getPlace(id);
		return new ResponseEntity<Places>(place,HttpStatus.OK);
	}

}
