package com.sds.dsvendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sds.dsvendas.dto.SaleDTO;
import com.sds.dsvendas.dto.SaleSuccessDTO;
import com.sds.dsvendas.dto.SaleSumDTO;
import com.sds.dsvendas.entities.Sale;
import com.sds.dsvendas.repositories.SaleRepository;
import com.sds.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository saleRepository;

	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){
		sellerRepository.findAll();
		Page<Sale> list = saleRepository.findAll(pageable);
		Page<SaleDTO> result = list.map(sale -> new SaleDTO(sale));
		
		return result;
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGrupedBySeller(){
		return saleRepository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successesGroupedBySeller(){
		return saleRepository.successesGroupedBySeller();
	}
}
