package net.softsociety.spring4.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Guestbook {
	int num;				//글번호
	String name;			//이름
	String password;		//비밀번호
	String contents;		//글내용
	String inputdate;		//작성시간

}
