package com.cwiztech.sectionc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cwiztech.sectionc.model.TransportRoute;
import com.cwiztech.sectionc.repository.transportRouteRepository;

@RestController
@CrossOrigin
@RequestMapping("/transportroute")
public class transportRouteController {

	@Autowired 
	private transportRouteRepository transportrouterepository;
	
	@RequestMapping(method = RequestMethod.GET)
	private List<TransportRoute> get() {
		List<TransportRoute> transportroutes = transportrouterepository.findActive();
		return transportroutes;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	private List<TransportRoute> getAll() {
		List<TransportRoute> transportroutes = transportrouterepository.findAll();
		return transportroutes;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	private TransportRoute getOne(@PathVariable Long id) {
		TransportRoute transportroute = transportrouterepository.findOne(id);
		return transportroute;
	}

	@RequestMapping(method = RequestMethod.POST)
	private TransportRoute insert(@RequestBody TransportRoute data) {
		TransportRoute transportroute = transportrouterepository.saveAndFlush(data);
		return transportroute;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	private TransportRoute update(@PathVariable Long id, @RequestBody TransportRoute data) {
		TransportRoute transportroute = transportrouterepository.saveAndFlush(data);
		return transportroute;
	}

}

