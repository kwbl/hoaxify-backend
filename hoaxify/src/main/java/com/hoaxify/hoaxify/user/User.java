package com.hoaxify.hoaxify.user;

import java.beans.Transient;
import java.util.Collection;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Data
@Entity
public class User implements UserDetails{
	
	@Id
	@GeneratedValue
	@JsonView(Views.Base.class)
	private long id;
	
	@NotNull(message = "{hoaxify.constraints.username.NotNull.message}")
	@Size(min = 4, max=255)
	@UniqueUsername
	@JsonView(Views.Base.class)
	private String username;
	
	@NotNull
	@Size(min = 4, max=255)
	@JsonView(Views.Base.class)
	private String displayName;
	
	@NotNull
	@Size(min = 8, max=255)
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message="{hoxify.constraints.password.Pattern.message}")
	private String password;
	
	@JsonView(Views.Base.class)
	private String image;

	@Override
	@Transient
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return AuthorityUtils.createAuthorityList("Role_USER");
	}

	@Override
	@Transient
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	@Transient
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	@Transient
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	@Transient
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
