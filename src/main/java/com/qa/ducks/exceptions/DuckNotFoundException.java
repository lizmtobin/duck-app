package com.qa.ducks.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No duck found with that id")

public class DuckNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -8783676132101421936L;
}
