package com.productapp.model.entities;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class ApiUser implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "user_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "user_gen", sequenceName = "user_seq", initialValue = 20, allocationSize = 1)
	@EqualsAndHashCode.Include
	private Integer apiuserId;

	@Column(length = 120)
	private String username;

	private String password;

	@ElementCollection
	@CollectionTable(name = "apiuser_roles", joinColumns = @JoinColumn(name = "apiuser_id"))
	private Set<String> roles;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// get the roles of type Set<String> and convert to List<GrantedAuthority>
		Set<String> roles = getRoles();
		// convert to stream and then use map method to convert to GrantedAuthorities
		return roles.stream().map(role -> new SimpleGrantedAuthority(role)).toList();
	}

}
