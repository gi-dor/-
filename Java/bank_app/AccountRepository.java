package Java.bank_app;

public class AccountRepository {

	// service에서 전달받은 값은 항상 옳다
	// 저장 , 삭제 , 읽기 , 수정은 의심하지말고 실행
	// Create  Read   Update   Delete
	
	
	
	// db[] 에는 100개중 6개만 값있음
	Account[] db = new Account[100];
	int savePosition = 0;
	
	public AccountRepository() {
		db[savePosition++] = new Account("11-11", "기선" , 1234 , 1000000);
		db[savePosition++] = new Account("11-22", "재훈" , 1234 , 2000000);
		db[savePosition++] = new Account("11-33", "성진" , 1234 , 3000000);
		db[savePosition++] = new Account("11-44", "병훈" , 1234 , 4000000);
		db[savePosition++] = new Account("11-55", "영선" , 1234 , 5000000);
		db[savePosition++] = new Account("11-66", "경혁" , 1234 , 6000000);
		db[savePosition++] = new Account("11-77", "창진" , 1234 , 7000000);
		db[savePosition++] = new Account("11-88", "준현" , 1234 , 10000000);
	}
	
	
	// findAll()
	// find             By   AccNo
	// find   Account   By   AccNo
	// find   Accounts  By   Owner
	
	/**
	 * 모든 계좌정보를 반환
	 * @return 모든 계좌 정보를줘야 하기 때문에 모든정보가 있는 배열객체 Account[]
	 */
	public Account[] findAll() {
		
		// 현재 result[] 에는6개 값중 6개값 가지고있는 배열
		Account[] result = new Account[savePosition];
		 
		
		for(int i = 0; i < savePosition; i++) {
			result[i] = db[i];
		}
		return result;
	
	}
	
	
	
	
	/**
	 *  계좌 정보를 전달받아 계좌 번호에 해당하는 계좌 정보를 반환
	 * @param accNo 입력으로 조회할 계좌번호
	 * @return 출력으로 계좌번호에 해당하는 정보 하나만 , 일치하는 계좌번호 업으면 null 반환
	 */
	public Account findAccountByAccNo(String accNo) {
		Account account = null;
		
		for(Account ac : db ) {
				if(ac == null) {
					break;
				}
			
		// 왜 == 를 사용하지 않고 equals를 썼을까 ? accNo가 String임  참조형에 ==은 주소 비교임
			if(ac.accNo.equals(accNo)) { 
				account = ac;
				break;
			}
		}
		
		return account;
	}
	
	
	
	/**
	 * 신규계좌 정보를 전달받아서 저장시킨다.
	 * @param account 신규계좌 정보
	 */
	public void save(Account account) {
		db[savePosition++] = account;
	}


	/**
	 * 계좌 번호를 전달받아 계좌번호에 해당하는 계좌정보를 삭제
	 * 	
	 * @param accNo 삭제할 계좌 번호
	 */
	public void remove(String accNo) {
		
		int findIndex = -1;
		for (int index = 0; index < savePosition; index++) {
			Account acc = db [index];
			if(acc.accNo.equals(accNo)) {
				findIndex = index;
				break;
			}
		}
		
		int beginIndex = findIndex +1;
		int endIndex = savePosition - 1;
		for(int index = beginIndex; index < savePosition; beginIndex++) {
			db[index - 1] = db[index]; 
		}
		db[savePosition - 1] = null;
		savePosition--;
	}
	
	
	
	
	
	
}

