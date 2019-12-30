package net.crunchdroid.service;

import lombok.AllArgsConstructor;
import net.crunchdroid.dao.ProduitFactureDao;
import net.crunchdroid.model.ProduitFacture;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProduitFactureService {

    private ProduitFactureDao produitFactureDao;

    public ProduitFacture save(ProduitFacture produitFacture) {
        return produitFactureDao.save(produitFacture);
    }

    public List<ProduitFacture> findAll() {
        return produitFactureDao.findAll();
    }

    public ProduitFacture getOneById(long id) {
        return produitFactureDao.getOne(id);
    }

    public ProduitFacture update(ProduitFacture produitFacture) {
        return this.save(produitFacture);
    }

    public boolean delete(long id) {
        ProduitFacture produitFacture = getOneById(id);
        try {
            produitFactureDao.delete(produitFacture);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
