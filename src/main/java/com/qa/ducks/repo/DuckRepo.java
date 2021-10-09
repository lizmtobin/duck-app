package com.qa.ducks.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.ducks.data.Duck;

@Repository
public interface DuckRepo extends JpaRepository<Duck, Integer> {

	public List<Duck> findByName(String name);

	public List<Duck> findByNameOrColour(String name, String colour);
}
