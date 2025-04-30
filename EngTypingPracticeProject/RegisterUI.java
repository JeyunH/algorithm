package kr.ac.kopo.ui.accessUI;

import kr.ac.kopo.ui.BaseUI;
import kr.ac.kopo.vo.UserVO;

public class RegisterUI extends BaseUI{

	@Override
	public void excute() throws Exception {
		title("회원가입");
		
		UserVO user = new UserVO();
		String id = scanStr("사용할 ID를 입력하세요 : ");
		
		user.setUserID(id);		//사용자ID 중복 체크
		while(true) {
			boolean check = userService.checkDuplicateID(user);
			if(check == true) {
				System.out.println("\n-------------------------------------");
				System.out.println("\t입력한 ID가 이미 존재합니다.");
				System.out.println("-------------------------------------\n");
				id = scanStr("다시 사용할 ID를 입력하세요 : ");
				user.setUserID(id);
			}else {
				break;
			}
		}
		
		String pwd;
		String pwd_check;
		while(true) {		//비밀번호 확인
			pwd = scanStr("비밀번호를 입력하세요 : ");
			pwd_check = scanStr("비밀번호 확인 : ");
			if(pwd.equals(pwd_check)) {
				break;
			}else {
				System.out.println("-------------------------------------");
				System.out.println("\t비밀번호가 틀렸습니다");
				System.out.println("-------------------------------------");
			}
		}
		String nick = scanStr("닉네임을 입력하세요 : ");
				
		user.setUserID(id);
		user.setPassword(pwd);
		user.setNickname(nick);
		userService.registerUser(user);
		Thread.sleep(300);
		System.out.println("\n-------------------------------------");
		System.out.println("\t계정이 생성되었습니다");
		System.out.println("-------------------------------------\n\n");
		Thread.sleep(1000);
		BaseUI.choice = "1";
	}
}
