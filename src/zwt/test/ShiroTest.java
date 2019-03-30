package zwt.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

import com.zwt.dao.impl.UserDaoImpl;
import com.zwt.modle.User;
import com.zwt.util.CryptographyUtil;

public class ShiroTest {
	public static void main(String[] args) {
		UserDaoImpl userdao = new UserDaoImpl();
		User user = userdao.selectUserByMailName("lyt@zwt.com");
		System.out.println(user.getPassword());
		
//		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
//		SecurityManager securityManager = factory.getInstance();
//		SecurityUtils.setSecurityManager(securityManager);
//		Subject currentUser = SecurityUtils.getSubject();
//		UsernamePasswordToken token = new UsernamePasswordToken("lyt@zwt.com",CryptographyUtil.md5("123321", "zwt.com"));
//		try {
//			currentUser.login(token);
//			System.out.println("³É¹¦");
//		}catch(AuthenticationException e) {
//			e.printStackTrace();
//			System.out.println("Ê§°Ü");
//		}
//		currentUser.logout();
	
	}
	public static boolean checkLogin(String userName, String password) {
		// TODO Auto-generated method stub
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(userName, CryptographyUtil.md5(password, "zwt.com"));
		
		try{
//			if(subject.isRemembered()){
//				System.out.println("---isRememberMe---");
//			}else{
//				token.setRememberMe(true);				
//			}
			subject.login(token);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
