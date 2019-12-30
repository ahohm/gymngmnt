package net.crunchdroid.dto;

import lombok.*;
import net.crunchdroid.model.Abonnement;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbonnementDto {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate debut;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fin;
    private long descipline;
    private long abonneid;


}
