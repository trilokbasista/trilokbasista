package eBIS.HomePage.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
public interface HomePageService {
	@Transactional(propagation=Propagation.REQUIRED)
	void getcount();

}
