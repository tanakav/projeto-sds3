package com.sds.dsvendas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sds.dsvendas.dto.SaleDTO;
import com.sds.dsvendas.dto.SaleSuccessDTO;
import com.sds.dsvendas.dto.SaleSumDTO;
import com.sds.dsvendas.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService saleService;
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable){
		Page<SaleDTO> list = saleService.findAll(pageable);
		
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value="total-by-seller")
	public ResponseEntity<List<SaleSumDTO>> totalBySeller(){
		List<SaleSumDTO> result = saleService.amountGrupedBySeller();
		
		return ResponseEntity.ok().body(result);
	}
	
	@GetMapping(value="success-by-seller")
	public ResponseEntity<List<SaleSuccessDTO>> successBySeller(){
		List<SaleSuccessDTO> list = saleService.successesGroupedBySeller();
		
		return ResponseEntity.ok().body(list);
	}
}
