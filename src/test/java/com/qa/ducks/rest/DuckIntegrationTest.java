package com.qa.ducks.rest;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.ducks.data.Duck;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc // sets up the mock MVC object
public class DuckIntegrationTest {

	@Autowired // inject the MockMVC into this class
	private MockMvc mvc; // object for sending mock http requests

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception {
		final Duck testDuck = new Duck(null, "red", "blue");
		String testDuckAsJSON = this.mapper.writeValueAsString(testDuck);

		final Duck savedDuck = new Duck(1, "red", "blue");
		String savedDuckAsJSON = this.mapper.writeValueAsString(savedDuck);

		// method, path, headers, body
		RequestBuilder request = post("/duck/create").contentType(MediaType.APPLICATION_JSON).content(testDuckAsJSON);

		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkContent = content().json(savedDuckAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkContent);
	}
}
