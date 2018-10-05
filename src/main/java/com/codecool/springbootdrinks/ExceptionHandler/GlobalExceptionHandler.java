package com.codecool.springbootdrinks.ExceptionHandler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import com.codecool.springbootdrinks.Service.EmailSender;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    @Autowired
    private EmailSender emailSender;

    private static final Logger log4j = LogManager.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(SQLException.class)
    public String handleSQLException(HttpServletRequest request, Exception ex){
        log4j.info("SQLException Occured:: URL="+request.getRequestURL());
        return "database_error";
    }

    @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="IOException occured")
    @ExceptionHandler(IOException.class)
    public void handleIOException(){
        log4j.error("IOException handler executed");
        //returning 404 error code
    }

    @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Resource not found")
    @ExceptionHandler(ResourceNotFoundException.class)
    public void handleResourceNotFoundException(){
        log4j.error("404 : Resource not found");
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Cannot connect to database")
    @ExceptionHandler(CannotGetJdbcConnectionException.class)
    public void handleJdbcConnectionException() {
        log4j.error("500 : db connection lost");
        String subject = "Database connection is down";
        String body = "Check database connection";
        emailSender.sendEmailWithoutTemplating(subject, body);
    }
}
