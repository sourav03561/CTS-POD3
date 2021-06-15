package com.cts.pmsm.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.pmsm.exception.AuthorizationException;
import com.cts.pmsm.model.JwtRequest;


@FeignClient("AUTHORIZATIION-MICROSERVICE")
public interface AuthorizingClient {
	
	@PostMapping(value = "/auth/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws AuthorizationException;
	
	@PostMapping("/auth/authorize")
	public boolean authorizeTheRequest(@RequestHeader(value = "Authorization", required = true) String requestTokenHeader);

}
