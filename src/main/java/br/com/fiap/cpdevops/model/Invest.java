package br.com.fiap.cpdevops.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="TB_INVEST")
public class Invest {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "USER_SEQ")
	@SequenceGenerator(sequenceName="user_sequence", allocationSize=1, name="USER_SEQ")
	private Long id;
	
	private String nome;
	
	private String cpf;
	
	private String conta;
	
	private int valorAporte;
	
	private boolean acoesFundo;
	
	private boolean cryptoFundo;
	
	
}
	
	