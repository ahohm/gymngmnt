package net.crunchdroid.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.crunchdroid.model.user.AppUser;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Msg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private AppUser source;

    @ManyToOne(cascade = CascadeType.DETACH)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private AppUser destination;

    private String object;

    private String text;

    private LocalDateTime dateTime;

    private boolean etat;
}
