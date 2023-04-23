package me.project.movie.handler;

import lombok.extern.slf4j.Slf4j;
import me.project.movie.controller.ScreeningController;
import me.project.movie.exception.HousefullException;
import me.project.movie.model.ErrorDetail;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@Slf4j
@RestControllerAdvice(assignableTypes = ScreeningController.class)
public class ScreeningExceptionHandler {

    @ExceptionHandler(HousefullException.class)
    public ResponseEntity<?> handleHouseFullException(HousefullException ex, WebRequest request) {

        log.debug("In Screening Exception Handler");


        ErrorDetail error = new ErrorDetail(new Date(), "House Full!", ex.toString());

        return new ResponseEntity<>(
                error, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
