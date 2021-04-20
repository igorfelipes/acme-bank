/**
 * 
 */
package br.com.bank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author cbgomes Classe de dominio da aplicação, modelo de persistência
 * 
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name ="clients")
@NamedQuery(name ="Client.getByName", query = "select c from Client c where c.name = :name")
@NamedQuery(name="Client.getAll", query = "select c from Client c")
@NamedQuery(name = "Client.getById", query = "select c from Client c where c.id = :id")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Column(name="email", unique=true)
	private String email;
	
	@Column(name="phone", unique=true)
	private String phone;

	
}
