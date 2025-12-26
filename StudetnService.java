package com.crud.serivce;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import com.crud.model.StudentModel;
import com.crud.wrapoer.StudentWrap;

@Service
public class StudetnService {

  

public 	Map<Integer, StudentModel> mymap =  new LinkedHashMap<>();
	AtomicInteger  genid = new AtomicInteger(100);

    
	
    
    // get all data
	public ResponseEntity<?> get()
	{
	Collection<StudentModel> newmap = mymap.values();
		
	if(newmap.size() == 0)
	{
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "empty data!!");
	}
	else
	{	
		StudentWrap swr = new StudentWrap();
		
		swr.setMesssage("data present ...");
		swr.setData(newmap);
		
		return new ResponseEntity<>(newmap, HttpStatus.FOUND);
	}
	}
	
	
	//add new data
	public ResponseEntity<?>add(StudentModel ref)
	{
		ref.setId(genid.incrementAndGet());
		StudentModel add = mymap.put(ref.getId(), ref);
		
		StudentWrap obj = new StudentWrap();
		obj.setMesssage("data added completly");
		obj.setData(add);
		
		return new ResponseEntity<>(obj,HttpStatus.OK);
		
	}
	
	//update existing data
	public ResponseEntity<?>update(int id, StudentModel ref)
	{
		if(mymap.containsKey(id))
		{
			ref.setId(id);
			StudentModel update=mymap.put(ref.getId(), ref);
			
			StudentWrap obj = new StudentWrap();
			obj.setMesssage("data update completly");
			obj.setData(update);
			return new ResponseEntity<>(obj,HttpStatus.OK);
		}
		else
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id not existing");
		}
	}
	
	//delete data
	public ResponseEntity<?>delete(int id)
	{
		if(mymap.containsKey(id))
		{
			StudentModel delete = mymap.remove(id);
		
			StudentWrap obj = new StudentWrap();
			obj.setMesssage("data delete completly");
			obj.setData(delete);
			return new ResponseEntity<>(obj,HttpStatus.OK);
		}
		else
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id not existing");
		}
	}
	
}
