package net.crunchdroid.service;

import lombok.AllArgsConstructor;
import net.crunchdroid.dao.AbonneDao;
import net.crunchdroid.model.Abonne;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AbonneService {

    private AbonneDao abonneDao;

    public Abonne save(Abonne abonne) {
        return abonneDao.save(abonne);
    }

    public List<Abonne> findAll() {
        return abonneDao.findAll();
    }

    public Abonne getOneById(long id) {
        return abonneDao.getOne(id);
    }

    public Abonne update(Abonne abonne) {
        return this.save(abonne);
    }

    public boolean delete(long id) {
        Abonne abonne = getOneById(id);
        try {
            abonneDao.delete(abonne);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
