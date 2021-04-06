package com.inuvens.SpringFlyway;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.inuvens.SpringFlyway.entities.Empresa;
import com.inuvens.SpringFlyway.repositories.EmpresaRepository;

@SpringBootApplication
public class SpringFlywayApplication {
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringFlywayApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			
			Empresa empresa = new Empresa();
			empresa.setRazaoScial("Inuvens IT");
			empresa.setCnpj("74645215000194");
			
			this.empresaRepository.save(empresa);
			
			List<Empresa> empresas = empresaRepository.findAll();
			empresas.forEach(System.out::println);

			/*Empresa empresaCNPJ = empresaRepository.fidByCnpj("74645215000194");
			System.out.println("Empresa por CNPJ:" + empresaCNPJ );*/
			
			this.empresaRepository.deleteById(2L);
			empresas = empresaRepository.findAll();
			System.out.println("Qtd. Empresas:" + empresas.size() );
			
			
		};	
	}

}
