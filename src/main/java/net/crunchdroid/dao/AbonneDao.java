package net.crunchdroid.dao;

import net.crunchdroid.model.Abonne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbonneDao extends JpaRepository<Abonne, Long> {

}
