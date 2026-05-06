package com.ipi.jva324.stock.service;

import java.util.List;

import com.ipi.jva324.stock.model.ProduitEnStock;
import com.ipi.jva324.stock.model.ReceptionDeProduit;

public interface ProduitService {

	List<ProduitEnStock> getProduits();

	ProduitEnStock getProduit(long id);

	ProduitEnStock createProduit(ProduitEnStock p);

	ProduitEnStock updateProduit(ProduitEnStock p);

	void deleteProduit(ProduitEnStock p);

	/**
	 * transactionnel
	 * TODO le type devrait être mappé... en pratique à la première commande fournisseur,
	 * sinon auto au réapprovisionnement auprès du même fournisseur
	 * @param rp
	 */
	ReceptionDeProduit recoitProduit(ReceptionDeProduit rp);

}