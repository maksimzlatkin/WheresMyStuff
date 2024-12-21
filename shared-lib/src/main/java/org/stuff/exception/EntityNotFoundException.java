package org.stuff.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@NoArgsConstructor
public class EntityNotFoundException extends RuntimeException{
    String message;
    public EntityNotFoundException(String message){
        super(message);
    }
}
