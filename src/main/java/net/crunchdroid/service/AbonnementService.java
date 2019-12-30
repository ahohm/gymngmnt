package net.crunchdroid.service;

import lombok.AllArgsConstructor;
import net.crunchdroid.dao.AbonnementDao;
import net.crunchdroid.model.Abonnement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AbonnementService {

    private AbonnementDao abonnementDao;

    public Abonnement save(Abonnement abonnement) {
        return abonnementDao.save(abonnement);
    }

    public List<Abonnement> findAll() {
        return abonnementDao.findAll();
    }

    public Abonnement getOneById(long id) {
        return abonnementDao.getOne(id);
    }

    public Abonnement update(Abonnement abonnement) {
        return this.save(abonnement);
    }

    public boolean delete(long id) {
        Abonnement abonnement = getOneById(id);
        try {
            abonnementDao.delete(abonnement);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
