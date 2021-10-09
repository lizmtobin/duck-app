package com.qa.ducks.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.ducks.data.Duck;
import com.qa.ducks.services.DuckService;

@RestController
@RequestMapping("/duck")
public class DuckController {

	private DuckService service;

	public DuckController(DuckService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Duck> create(@RequestBody Duck newDuck) {
		return new ResponseEntity<Duck>(this.service.create(newDuck), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public Duck getById(@PathVariable Integer id) {
		return this.service.getById(id);
	}

	@GetMapping("/")
	public List<Duck> getAll() {
		return this.service.getAll();
	}

	@GetMapping("/getByNameOrColour/{name}/{colour}")
	public List<Duck> getByNameOrColour(@PathVariable String name, @PathVariable String colour) {
		return this.service.getByNameOrColour(name, colour);
	}

	@GetMapping("/getByParameters")
	public List<Duck> getByParameters(@PathParam("name") String name, @PathParam("colour") String colour) {
		return this.service.getByNameOrColour(name, colour);
	}

	@GetMapping("/getByName/{name}")
	public List<Duck> getByName(@PathVariable String name) {
		return this.service.getByName(name);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Duck> updateDuck(@PathVariable Integer id, @RequestBody Duck newDuck) {
		return new ResponseEntity<Duck>(this.service.updateDuck(id, newDuck), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<?> removeDuck(@PathVariable Integer id) {
		if (this.service.removeDuck(id)) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
