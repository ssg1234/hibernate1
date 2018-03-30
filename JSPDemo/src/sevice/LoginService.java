package sevice;

import com.Login;

import dao.LoginDao;

public class LoginService {
	public String checkUser(Login ll) {
		LoginDao ld=new LoginDao();
		if(ld.checkUser(ll)) {
			return "success";
			
		}else
		{
			return "failure";
		}
	}

}
