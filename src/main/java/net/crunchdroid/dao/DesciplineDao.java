package net.crunchdroid.dao;

import net.crunchdroid.model.Descipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesciplineDao extends JpaRepository<Descipline, Long> {
}
