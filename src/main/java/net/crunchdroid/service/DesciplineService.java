package net.crunchdroid.service;

import lombok.AllArgsConstructor;
import net.crunchdroid.dao.DesciplineDao;
import net.crunchdroid.model.Descipline;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DesciplineService {

    private DesciplineDao desciplineDao;

    public Descipline save(Descipline descipline) {
        return desciplineDao.save(descipline);
    }

    public List<Descipline> findAll() {
        return desciplineDao.findAll();
    }

    public Descipline getOneById(long id) {
        return desciplineDao.getOne(id);
    }

    public Descipline update(Descipline descipline) {
        return this.save(descipline);
    }

    public boolean delete(long id) {
        Descipline descipline = getOneById(id);
        try {
            desciplineDao.delete(descipline);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
