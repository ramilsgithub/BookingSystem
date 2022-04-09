package az.softsolution.bookingsystem.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessage {
    private int status;
    private String message;
}
