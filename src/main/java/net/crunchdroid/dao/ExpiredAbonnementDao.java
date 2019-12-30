package net.crunchdroid.dao;

import net.crunchdroid.model.ExpiredAbonnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpiredAbonnementDao extends JpaRepository<ExpiredAbonnement, Long> {
}
