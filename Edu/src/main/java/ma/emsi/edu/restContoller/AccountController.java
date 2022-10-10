package ma.emsi.edu.restContoller;

import java.nio.file.attribute.UserPrincipal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import ma.emsi.edu.auth.AuthenticationResponse;
import ma.emsi.edu.auth.LoginRequest;
import ma.emsi.edu.model.Utilisateur;
import ma.emsi.edu.repository.UtilisateurRepository;
import ma.emsi.edu.security.JWTTokenProvider;
import ma.emsi.edu.security.JWTUtils;
import ma.emsi.edu.service.UtilisateurService;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {
	
	@Autowired
	private AuthenticationManager authenticationManager ;
	
	@Autowired
	UtilisateurService utilisateurService ;
	
	@Autowired
	UtilisateurRepository repository ;

	@Autowired
	JWTUtils jwt ;
	@PostMapping("/authenticate")
	
	public ResponseEntity<?> authenticate( @RequestBody LoginRequest request){
		System.out.println("print" + request);
	 authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		 UserDetails userDetails = utilisateurService.loadUserByUsername(request.getUsername());
		Utilisateur user = repository.findByUserName(request.getUsername());
		final String jw = jwt.generateToken(userDetails);
		AuthenticationResponse authenticationResponse = new AuthenticationResponse(jw , userDetails.getUsername() , user.getRoles().get(0).getNom(),user.getId());
		System.out.println(request.getUsername());
		System.out.println(authenticationResponse.getAccessToken());
		return ResponseEntity.ok(authenticationResponse);
		
	}

}
