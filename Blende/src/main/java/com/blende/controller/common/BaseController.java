package com.blende.controller.common;

import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.blende.dto.PageInfo;
import com.fasterxml.jackson.databind.ObjectMapper;



@PropertySource(value = {"classpath:app-settings.properties"})
public class BaseController {
	protected static final Logger logger = Logger.getLogger(BaseController.class);

    @Autowired
    protected ModelMapper mapper;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    protected Environment env;

    protected PageInfo getDefaultPageInfo(int page){
        final int pageSize = env.getProperty("app.pageSize",int.class);
        return new PageInfo(page,pageSize);
    }

    /*@ExceptionHandler(BadRosterStatusException.class)
    public ResponseEntity<String> handleIOException(BadRosterStatusException ex) {
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAuthenticationException.class)
    public ResponseEntity<String> handleLoginException(UserAuthenticationException ex) {
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.UNAUTHORIZED);
    }*/
}
