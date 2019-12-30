package net.crunchdroid.service;

import net.crunchdroid.dao.ExpiredAbonnementDao;
import net.crunchdroid.model.ExpiredAbonnement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpiredAbonnementService {

    @Autowired
    private ExpiredAbonnementDao expiredAbonnementDao;

    public ExpiredAbonnement save(ExpiredAbonnement expiredAbonnement) {
        return expiredAbonnementDao.save(expiredAbonnement);
    }

    public List<ExpiredAbonnement> findAll() {
        return expiredAbonnementDao.findAll();
    }


    public ExpiredAbonnement getOneById(long id) {
        return expiredAbonnementDao.getOne(id);
    }

    public ExpiredAbonnement update(ExpiredAbonnement expiredAbonnement) {
        return this.save(expiredAbonnement);
    }

    public boolean delete(long id) {
        ExpiredAbonnement expiredAbonnement = getOneById(id);
        try {
            expiredAbonnementDao.delete(expiredAbonnement);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
