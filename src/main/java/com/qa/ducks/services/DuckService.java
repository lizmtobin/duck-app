package com.qa.ducks.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.ducks.data.Duck;
import com.qa.ducks.repo.DuckRepo;

@Service
public class DuckService {

	private DuckRepo repo;

	public DuckService(DuckRepo repo) {
		super();
		this.repo = repo;
	}

	public Duck create(Duck newDuck) {
		return this.repo.save(newDuck);
	}

	public Duck getById(Integer id) {
		return this.repo.findById(id).orElseThrow(DuckNotFoundException::new);
	}

	public List<Duck> getAll() {
		return this.repo.findAll();
	}

	public List<Duck> getByName(String name) {
		return this.repo.findByName(name);
	}

	public Duck updateDuck(Integer id, Duck newDuck) {
		Duck oldDuck = this.repo.findById(id).orElseThrow(DuckNotFoundException::new);

		oldDuck.setColour(newDuck.getColour());
		oldDuck.setName(newDuck.getName());

		return this.repo.save(oldDuck);
	}

	public boolean removeDuck(Integer id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
