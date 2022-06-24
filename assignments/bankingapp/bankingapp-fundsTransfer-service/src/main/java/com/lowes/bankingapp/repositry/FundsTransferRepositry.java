package com.lowes.bankingapp.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lowes.bankingapp.entity.FundsTransfer;
@Repository
public interface FundsTransferRepositry extends JpaRepository<FundsTransfer, Integer> {

	/*
	 * public List<FundsTransfer> findByName(String name);
	 * 
	 * public List<FundsTransfer> findByPrimeAndLocation(boolean prime, String
	 * location);
	 */

//	@Query("select e from Customer e where e.location = :location")
//	public List<Customer> findByTypeQuery(@Param("location") String location);

}
