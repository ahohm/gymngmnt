package net.crunchdroid.dao;

import net.crunchdroid.model.Abonne;
import net.crunchdroid.model.Abonnement;
import net.crunchdroid.model.AbonnementFacture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbonnementFactureDao extends JpaRepository<AbonnementFacture, Long> {
    List<AbonnementFacture> findAllByAbonne(Abonne abonne);

    AbonnementFacture findAllByAbonnement(Abonnement abonnement);
}
