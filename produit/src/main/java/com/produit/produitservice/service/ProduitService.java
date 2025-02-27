package com.produit.produitservice.service;

import com.produit.produitservice.model.Produit;
import com.produit.produitservice.repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProduitService {
    private final ProduitRepository produitRepository;

    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public Produit createProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    public Produit getProduitById(long id) {
        Optional<Produit> optionalProduit = produitRepository.findById(id);
        if(optionalProduit.isEmpty()){
            throw new RuntimeException("Produit n'existe pas");
        }
        return optionalProduit.get();
    }
    public Produit updateProduitById(long id, Produit produit){
        Optional<Produit> optionalProduit = produitRepository.findById(id);
        if(optionalProduit.isEmpty()){
            throw new RuntimeException("Produit introuvable");
        }
        Produit produitARemplacer = optionalProduit.get();
        produitARemplacer.setName(produit.getName());
        produitARemplacer.setPrice(produit.getPrice());
        return produitRepository.save(produitARemplacer);
    }
    public String deleteProduitById(long id){
        Optional<Produit> optionalProduit = produitRepository.findById(id);
        if(optionalProduit.isEmpty()){
            throw new RuntimeException("Suppression impossible : le produit est introuvable");
        }
        produitRepository.deleteById(id);
        return "Suppression faite avec succès";
    }
}
