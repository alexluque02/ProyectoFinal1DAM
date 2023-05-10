package com.salesianos.triana.dam.clubDeportivo.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.salesianos.triana.dam.clubDeportivo.repository.SocioRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{

	private final SocioRepositorio repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return repo.findFirstByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Error al buscar el usuario"));
	}

}