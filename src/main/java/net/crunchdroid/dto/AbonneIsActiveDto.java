package net.crunchdroid.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.crunchdroid.model.Abonne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbonneIsActiveDto {

    private Abonne abonne;
    private boolean isActive;
}
