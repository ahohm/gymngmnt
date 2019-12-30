package net.crunchdroid.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.crunchdroid.model.Abonne;
import net.crunchdroid.model.Abonnement;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AbonnementActiveDto {

    private Abonnement abonnement;
    private boolean isActive;
    private Abonne abonne;
}
