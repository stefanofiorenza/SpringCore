package com.knits.spring.common.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Data;

@Data
public class ServiceWithCollections {

	List<String> technologySkillsList= new ArrayList<String>();
	Set<String> technologySkillsSet= new HashSet<String>();
	Map<String,String> technologySkillsMap= new HashMap<String,String>();
	
}
