package net.crunchdroid.service;


import lombok.AllArgsConstructor;
import net.crunchdroid.dao.MsgDao;
import net.crunchdroid.model.Msg;
import net.crunchdroid.model.user.AppUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MsgService {

    private MsgDao msgDao;

    public Msg save(Msg msg) {
        return msgDao.save(msg);
    }

    public List<Msg> findAll() {
        return msgDao.findAll();
    }

    public List<Msg> findAllByDestination(AppUser appUser) {
        return msgDao.findAllByDestination(appUser);
    }

    public List<Msg> findAllBySource(AppUser appUser) {
        return msgDao.findAllBySource(appUser);
    }

    public Msg getOneById(long id) {
        return msgDao.getOne(id);
    }

    public Msg update(Msg msg) {
        return this.save(msg);
    }

    public boolean delete(long id) {
        Msg msg = getOneById(id);
        try {
            msgDao.delete(msg);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
