package com.digitalaube.checkart.rest;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalaube.checkart.bean.Role;
import com.digitalaube.checkart.bean.Rolev;
import com.digitalaube.checkart.bean.User;
import com.digitalaube.checkart.jwt.JwtTokenProvider;
import com.digitalaube.checkart.service.UserService;

@RestController
@RequestMapping("/checkart/api/user")
public class userRest {
	@Autowired
	private UserService userService;
	@Autowired
	private JwtTokenProvider tokenProvider;

@PostMapping("/registration")
public ResponseEntity<?> register(@RequestBody User user){
    if(userService.findByEmail(user.getEmail())!=null){
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
    user.setRole(Role.USER);
    return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
}

@GetMapping("/login")
public ResponseEntity<?> getUser(Principal principal){
     if(principal == null){
        return ResponseEntity.ok(principal);
    }
    UsernamePasswordAuthenticationToken authenticationToken =
            (UsernamePasswordAuthenticationToken) principal;
    User user = userService.findByEmail(authenticationToken.getName());
    System.out.println(user);
    user.setToken(tokenProvider.generateToken(authenticationToken));

    return new ResponseEntity<>(user, HttpStatus.OK);
}

}
