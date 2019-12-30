package net.crunchdroid.dao;

import net.crunchdroid.model.ProduitFacture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitFactureDao extends JpaRepository<ProduitFacture, Long> {
}
