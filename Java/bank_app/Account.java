package Java.bank_app;

/**
 * 은행 게좌 정보를 표현하는 클래스
 */
public class Account {

	String accNo;			// 계좌번호
	String owner;			// 예금주 이름
	int password;			// 비밀번호
	long balance; 			// 잔고
	double interestRate;	// 이자 율
	boolean expired;		// 폐기여부
	
	public Account(String accNo , String owner  , int password , long balance) {
		this.accNo = accNo;
		this.owner = owner;
		this.password = password;
		this.balance = balance;
		this.interestRate = 0.05;
	}
	
	
	public void display() {
		System.out.println(accNo + " \t\t " + owner + "\t\t" + balance);
		System.out.println();
	}
	
	public void displayDetail() {
		System.out.println();
		System.out.println("#### 계좌 상세정보 ####");
		System.out.println("계좌번호 : " + accNo);
		System.out.println("예금주 명 : " + owner);
		System.out.println("현재 잔액 : " + balance);
		System.out.println("적립 이율: " + interestRate);
		System.out.println("폐기여부: " + expired);
		System.out.println("##########################");
		System.out.println();
	}
}
