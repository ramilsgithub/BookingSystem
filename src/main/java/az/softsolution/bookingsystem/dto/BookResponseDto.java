package az.softsolution.bookingsystem.dto;


import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDto {

    private Long bookId;
    private Long flightId;
    private String name;
    private String surname;

}
