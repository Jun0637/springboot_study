package net.softsociety.spring4.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.softsociety.spring4.dao.GuestbookDAO;
import net.softsociety.spring4.domain.Guestbook;

@Service
public class GuestbookService {

	@Autowired
	GuestbookDAO dao;
	
	public int insert(Guestbook gb) {
		int n = dao.insert(gb);
		return n;
	}
	
	public ArrayList<Guestbook> list() {
		ArrayList<Guestbook> glist = dao.list();
		return glist;
	}
	
	public int delete(Guestbook gb) {
		int n = dao.delete(gb);
		return n;
	}
	
}






