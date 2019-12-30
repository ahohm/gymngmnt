package net.crunchdroid.service;

import lombok.AllArgsConstructor;
import net.crunchdroid.dao.EntraineurDao;
import net.crunchdroid.model.Entraineur;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EntraineurService {

    private EntraineurDao entraineurDao;

    public Entraineur save(Entraineur entraineur) {
        return entraineurDao.save(entraineur);
    }

    public List<Entraineur> findAll() {
        return entraineurDao.findAll();
    }

    public Entraineur getOneById(long id) {
        return entraineurDao.getOne(id);
    }

    public Entraineur update(Entraineur entraineur) {
        return this.save(entraineur);
    }

    public boolean delete(long id) {
        Entraineur entraineur = getOneById(id);
        try {
            entraineurDao.delete(entraineur);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
