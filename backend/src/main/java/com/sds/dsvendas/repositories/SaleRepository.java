package com.sds.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sds.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale,Long>{

}
