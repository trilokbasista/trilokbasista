package eBIS.HomePage.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eBIS.HomePage.DAO.HomePageDAO;

@Service
public class HomePageServiceImp implements HomePageService {

	@Autowired 
	HomePageDAO dao;
	
	@Override
	public void getcount() {
		dao.getcount();
		
	}

}
