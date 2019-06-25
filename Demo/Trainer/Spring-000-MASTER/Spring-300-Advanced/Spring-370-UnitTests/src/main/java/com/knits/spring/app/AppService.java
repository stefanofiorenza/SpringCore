package com.knits.spring.app;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class AppService {

	@Setter
	@Getter
	private List<String> repository;
	
	
	public void add(String data){
		if(data.startsWith("S")){
			repository.add(data);
		}
		
	}
	
	public void remove(int position){
		
		position= position-1;
		if(position<0 || repository.size()<1){
			throw new IllegalStateException("Array is not ready");
		}
		repository.remove(position);		
	}
	
	public void update(String data, int position){	
		if(position%5==0){
			repository.add(position,data);
			repository.remove(position+1);
		}
		
	}
	
	public String findFirst(){
		return repository.get(0);
	}
	
	public List<String> listAll(){
		List<String> resultSet = new ArrayList<String>(); 
		for (int i=0; i<repository.size(); i++){
			String result = repository.get(i);
			if(result.startsWith("S")){
				resultSet.add(result);
			}
		}
		return resultSet;
	}
	
	public String findByPosition(int position){
		if(position<0){
			return "Default Data";
		}
		return repository.get(position);
	}
	
}
