package net.crunchdroid.service;

import lombok.AllArgsConstructor;
import net.crunchdroid.dao.AbonnementFactureDao;
import net.crunchdroid.model.Abonne;
import net.crunchdroid.model.Abonnement;
import net.crunchdroid.model.AbonnementFacture;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AbonnementFactureService {

    private AbonnementFactureDao abonnementFactureDao;

    public AbonnementFacture save(AbonnementFacture abonnementFacture) {
        return abonnementFactureDao.save(abonnementFacture);
    }

    public List<AbonnementFacture> findAll() {
        return abonnementFactureDao.findAll();
    }

    public AbonnementFacture getOneById(long id) {
        return abonnementFactureDao.getOne(id);
    }

    public AbonnementFacture update(AbonnementFacture abonnementFacture) {
        return this.save(abonnementFacture);
    }

    public boolean delete(long id) {
        AbonnementFacture abonnementFacture = getOneById(id);
        try {
            abonnementFactureDao.delete(abonnementFacture);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<AbonnementFacture> getAllByAbonne(Abonne abonne) {
        return abonnementFactureDao.findAllByAbonne(abonne);
    }

    public AbonnementFacture getAllByAbonnement(Abonnement abonnement) {
        return abonnementFactureDao.findAllByAbonnement(abonnement);
    }
}
