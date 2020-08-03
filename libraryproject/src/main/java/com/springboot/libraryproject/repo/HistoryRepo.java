package com.springboot.libraryproject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.libraryproject.entity.History;

public interface HistoryRepo extends JpaRepository<History, Integer>{
	
	List<History> findByUseridOrderByIssuedateDesc(int userid);
	
	@Query(value = "SELECT * FROM HISTORY WHERE isreturned = \"yes\" ORDER BY issuedate DESC", nativeQuery = true)
	List<History> findHistory();

}
