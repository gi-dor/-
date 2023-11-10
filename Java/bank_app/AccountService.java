package Java.bank_app;

import java.util.Arrays;

public class AccountService {
	
	
	/*
	 * 유효한 형식의 값을 받았다고 가정하고 업무를 한다
	 * 입금하기 , 출금하기 , 비밀번호 변경하기등 구체적이다
	 * 예를들어 입금하기
	 * R - 계좌가 존재하는지 읽기
	 * U - 존재하는 계좌가있다면 금액을 입금해서 수정함
	 */

	AccountRepository repo = new AccountRepository();
	
	
	
	/** 전체 계좌 조회
	 * 모든 계좌 정보를 반환하는 서비스
	 * @return 계좌정보 배열
	 */
	public Account[] getAllAccounts() {
	
		Account[] accounts = repo.findAll();
		System.out.println(Arrays.toString(accounts));
		return accounts;
	}
	
	
	
	
	
	/**
	 * 지정된 계좌번호에 대하는 계좌정보 반환
	 * @param accNo 계좌 번호로 찾는다
	 * @return
	 */
	public Account getAccount(String accNo) {
		Account account = repo.findAccountByAccNo(accNo);
		return account;
	}
	
	
	
	/**
	 * 신규계좌 정보를 전달받아서 계좌를 개설한다 , 동일한 계좌번호로 개설할 수는 없다
	 * @param account 신규 계좌정보
	 * @return 계좌개설이 완료되면 true , 실패시 false 반환
	 */
	
	public boolean createAccount(Account account) {
		// 중복되는 계좌가 있는지 Account account에 있는 accNo로 찾아봄
		Account savedAccount = repo.findAccountByAccNo(account.accNo);
		
		// savedAccount != null 은 이미 존재하는 계좌 번호이기 때문에 바로 종료하게 
		// return false;를 걸었다
		if(savedAccount != null) {
			System.out.println("### 이미 사용중인 계좌 번호 입니다");
			return false;
		}
		// 위에 if문이 return false시 하단으로 와서 실행해 return true 반환
		repo.save(account);
		return true;
		
	}
	

	
	
	
	
	/**
	 * 지정된 계좌번호에 입금액만큼 금액을 입금 시킨다
	 * @param accNo 계좌번호
	 * @param amount 입금액
	 * @return 입금완료시 true 반환
	 */
	public boolean deposit(String accNo , long amount) {
		// 계좌정보 존재하는지 확인
		Account savedAccount = repo.findAccountByAccNo(accNo);
		if(savedAccount == null) {
			System.out.println("### 입금할 계좌가 존재 하지 않습니다");
			return false;
		}
		
		// 계좌정보가 존재한다
		savedAccount.balance += amount;
		return true;
	}




	/**
	 * 지정된 계좌의 비밀번호를 변경한다 
	 * 이전 비밀번호와 새비밀번호가 일치하면 실패
	 * 해당하는 계좌번호가 존재하지 않으면 실패
	 * 계좌번호가 이전 비밀번호가 일치하지 않으면 실패
	 * @param accNo 계좌번호
	 * @param oldPwd 기존 비밀번호
	 * @param newPwd 새로운 비밀번호
	 */
	
	public boolean changePassword(String accNo, int oldPwd, int newPwd) {
		// TODO Auto-generated method stub
	
		if(oldPwd == newPwd) {
			System.out.println("### 이전 비밀번호와 같은 비밀번호로 변경할수 없습니다");
			return false;
		}
		
		Account savedAccount = repo.findAccountByAccNo(accNo);
		if(savedAccount == null) {
			System.out.println("### 계좌번호가 올바르지 않습니다 ");
			System.out.println("### 다시 확인해주세요");
			
			return false;
		}
		
		if(savedAccount.password != oldPwd) {
			System.out.println("### 비밀번호가 올바르지 않습니다");
			System.out.println("### 다시 확인해주세요");
			
			return false;
		}
		
		return true;
		
	}



			
	/**
	 * 지정된 계좌번호를 폐기한다 
	 * 계좌번호가 존재 하지 않을시 실패
	 * 비밀번호가 일치 하지 않을시 실패
	 * @param accNo 계좌번호
	 * @param password 비밀번호
	 * @return 계좌 폐기가 완료되면 true 반환
	 */
	public boolean expire(String accNo, int password) {
		// TODO Auto-generated method stub
		
		Account savedAccount = repo.findAccountByAccNo(accNo);
		
		if(savedAccount == null) {
			System.out.println("### 계좌 정보가 올바르지 않습니다");
			
			return false;
		}
		if(savedAccount.password != password) {
			System.out.println("### 비밀번호가 일치하지 않습니다.");
			
			return false;
		}
		repo.remove(accNo);
		return true;
	}





	
	
	// 출금기능
	
	// 비밀번호 변경기능
	
	// 계좌해지 기능








}
