package Java.bank_app;

//  메뉴 표시 , 사용자와 상호작용 
// 형식에 맞는지 판단은 UI에 서 판단한다 
// 값의' 유효성 ' 테스트

public class AccountUI {
	
	/*
	 * -------------------------------------------
	 * 키보드로 입력받아서 상호작용하는 페이지
	 * 사용자는 콘솔과 키보드를 통해 이용한다
	 * 
	 * -------------------------------------------
	 */
	
	
	AccountService service = new AccountService();
	
	Scanner scanner = new Scanner(System.in);
	
	public void menu() {
		System.out.println("=============================================================");
		System.out.println("====================== 스마트 뱅킹 ==========================");
		System.out.println("=============================================================");

		System.out.println(" 1.전체조회 2.상세조회 3.신규가입 4.입금 5.출금 ");
		System.out.println(" 6.비밀번호 변경 7.계좌해지 0.종료 ");
		System.out.println("--------------------------------------------------------------");
		
		System.out.println("### 메뉴 선택 : ");
		int menuNo = scanner.nextInt();
		
		if (menuNo == 1) {
			전체조회();
		} else if (menuNo == 2) {
			상세조회();
		} else if (menuNo == 3) {
			신규();
		} else if (menuNo == 4) {
			입금();
		} else if (menuNo == 5) {
			출금();
		} else if (menuNo == 6) {
			비밀번호변경();
		} else if (menuNo == 7) {
			해지();
		} else if (menuNo == 0) {
			System.out.println("##### 프로그램 종료 합니다");
			System.exit(0);
		}
		System.out.println();

		menu();
		
		
		
	}
	
	/*
	 * 전체 계좌정보 출력
	 */
	public void 전체조회() {
		System.out.println(" << 전체 계좌 정보 조회 >> ");
		
		Account[] accounts = service.getAllAccounts();
		
		System.out.println("------------------------------------------");
		System.out.println("계좌번호 \t 예금주 \t 입금액");
		System.out.println("-------------------------------------------");
		
		for(Account ac : accounts) {
			ac.display();
		}
	}
	/*
	 * 계좌번호를 입력받아 해당 계좌번호에 대한 상세정보를 출력한다
	 */
	public void 상세조회() {
		System.out.println("<< 계좌 정보 상세조회 >> ");

		System.out.print("조회할 계좌 번호 : ");
		String accNo = scanner.nextString();
		
		
		Account account = service.getAccount(accNo);
		
		if(account != null) {
			account.displayDetail();
		} else {
			System.out.println("계좌 정보가 존재 하지 않습니다.");
		}
		
	
		
	}
	/*
	 * 계좌번호 , 예금주명 , 비밀번호 , 최초입금액을 입력받아 신규 계좌를 개설한다
	 * Ex. 형식에 맞는 값인지 확인
	 */
	public void 신규() {
		System.out.println("<< 신규 계좌 개설>>");
		
		System.out.println("### 신규 계좌 개설에 필요한 정보를 입력하세요");
		
		System.out.print("### 계좌번호 입력 : ");
		String accNo = scanner.nextString();
		
		System.out.print("### 예금주명 입력 : ");
		String owner = scanner.nextString();
		
		System.out.print("### 비밀번호 입력 : ");
		int passwod = scanner.nextInt();
		
		System.out.print("### 최초 입금액 입력 : ");
		long balance = scanner.nextLong();
		
		Account account = new Account(accNo, owner, passwod, balance);
		boolean succed = service.createAccount(account);
		
		if(succed) {
			System.out.println("### 신규 계좌가 개설되었습니다");
		} else {
			System.out.println("### 신규 계좌 개설에 실패 했습니다.");
		}
		
		
	}
	
	
	
	
	
	
	
	/*
	 * 계좌번호 , 입금액을 입력받아 해당계좌에 입금한다
	 */
	public void 입금() {
		System.out.println("<< 입금 하기 >>");
		
		System.out.println("계좌번호와 입금액을 입력하세요");
		
		System.out.print("계좌번호 입력 : ");
		String accNo = scanner.nextString();
		
		System.out.print("입금액 입력 : ");
		long amount = scanner.nextLong();
		
		boolean succed = service.deposit(accNo , amount);
		if(succed) {
			System.out.println("### 입금이 완료되었습니다");
		} else {
			System.out.println("### 입금처리 중 오류가 발생 했습니다.");
			System.out.println("### 계좌번호를 다시 확인 해주세요");
		}
	}
	/*
	 * 계좌번호 , 비밀번호 , 출금액을 입력받아 해당계좌에서 출금액만큼 출금한다
	 */
	public void 출금() {
		
	}
	/*
	 * 계좌번호 , 이전 비밀번호 , 새 비밀번호를 입력받아 해당계좌의 비밀번호를 변경
	 */
	public void 비밀번호변경() {
		
		System.out.println("<< 계좌 비밀번호 변경 >>");
		System.out.println("### 비밀번호 변경에 필요한 계좌번호 , 이전 비밀번호 , 새 비밀번호 입력하세요");
		
		System.out.print("### 계좌번호 입력 : ");
		String accNo = scanner.nextString();
		
		System.out.print("### 이전 비밀번호 입력 : ");
		int oldPwd =  scanner.nextInt();
		
		System.out.print("### 새로운 비밀번호 입력 : ");
		int newPwd = scanner.nextInt();
		
		boolean succed = service.changePassword(accNo , oldPwd , newPwd);
		if(succed) {
			System.out.println("### 비밀번호가 변경 되었습니다");
		} else {
			System.out.println("### 비밀번호 변경 중 오류가 발생했습니다");
			System.out.println("### 다시 시도해주세요");
		}
	}
	/*
	 * 계좌번호 , 비밀번호를 입력받아 해당계좌를 해지시킨다.
	 */
	public void 해지() {
		System.out.println("<< 계좌 해지 >>");
		
		System.out.println("### 계좌번호 , 비밀번호를 입력하세요");
		
		System.out.print("### 계좌번호 입력 : ");
		String accNo = scanner.nextString();
		
		System.out.print("### 비밀번호 입력 : ");
		int password = scanner.nextInt();
	
		boolean succed = service.expire(accNo , password);
		
		if(succed) {
			System.out.println("### 해지 처리 되었습니다");
		} else {
			System.out.println("### 해지 처리중 오류가 발생하였습니다");
		}
	}
	
}
