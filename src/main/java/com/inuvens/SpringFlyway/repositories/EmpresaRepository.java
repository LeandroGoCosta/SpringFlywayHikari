package com.inuvens.SpringFlyway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inuvens.SpringFlyway.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long >{
	
	//Empresa fidByCnpj(String cnpj);	

}
