package uz.tigersteam.http;

import lombok.Getter;

import java.util.Date;

/**
 * @author Nodirbek Abdukarimov Fri. 10:00 AM. 12/24/2021
 */
@Getter
public class ResponseEntity<B> {
    private B body;
    private Integer code;
    private Date time;

    public ResponseEntity(B body) {
        this(body, HttpStatus.HTTP_200);
    }

    public ResponseEntity(B body, HttpStatus status) {
        this.body = body;
        this.code = status.getCode();
        this.time = new Date();
    }
}
