package com.sds.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.dsvendas.dto.SellerDTO;
import com.sds.dsvendas.entities.Seller;
import com.sds.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository sellerRepository;
	
	public List<SellerDTO> findAll(){
		List<Seller> sellers = sellerRepository.findAll();
		List<SellerDTO> result = sellers.stream().map(seller -> new SellerDTO(seller)).collect(Collectors.toList());
		return result;
	}

}
