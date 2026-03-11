package com.cwiztech.sectionc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cwiztech.sectionc.model.TransportRoute;

public interface transportRouteRepository extends JpaRepository<TransportRoute, Long> {
	
	@Query(value = "select * from TBLTRANSPORTROUTE where ISACTIVE='Y'", nativeQuery = true)
public List<TransportRoute> findActive();
	

}
