package net.softsociety.spring5.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	String memberid; 
	String memberpw; 
	String membername; 
	String email; 
	String phone; 
	String address; 
	boolean enabled; 
	String rolename; 

}
