package net.crunchdroid.service;

import lombok.AllArgsConstructor;
import net.crunchdroid.dao.ProduitDao;
import net.crunchdroid.model.Produit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProduitService {

    private ProduitDao produitDao;

    public Produit save(Produit produit) {
        return produitDao.save(produit);
    }

    public List<Produit> findAll() {
        return produitDao.findAll();
    }

    public Produit getOneById(long id) {
        return produitDao.getOne(id);
    }

    public Produit update(Produit produit) {
        return this.save(produit);
    }

    public boolean delete(long id) {
        Produit produit = getOneById(id);
        try {
            produitDao.delete(produit);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
