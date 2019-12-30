package net.crunchdroid.batch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SmsRequest {

    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String message;
}
