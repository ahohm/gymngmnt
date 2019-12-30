package net.crunchdroid.dao;

import net.crunchdroid.model.Abonnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AbonnementDao extends JpaRepository<Abonnement, Long> {
}
