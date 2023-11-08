package Java.oop01.method;

public class BankAccount {
    // 멤버변수 정의 (iv)
    String owner;			// 예금주
    String accNo;			// 계좌번호
    int password;			// 비밀번호
    long balance;			// 현재 잔액
    double interestRate;	// 이율


    // 생성자 정의하기
    public BankAccount(String owner , String accNo , int password , long balance , double interestRate) {
        this.owner = owner;
        this.accNo = accNo;
        this.password = password;
        this.balance = balance;
        this.interestRate = interestRate;
    }

    // 메서드 정의

    // 계좌정보 화면에 출력하기
    public void display() {
        System.out.println("### 계좌정보 확인");
        System.out.println("예금주 : " + owner);
        System.out.println("계좌번호 : " + accNo);
        System.out.println("현재 잔액 : " + balance);
    }

    // 입금하기
    /**
     * 입금액을 전달받아 , 계좌의 잔액을 입금액 만큼 증가시킨다
     * @param amount 입금액
     */

    public void deposit(int amount) {
        System.out.println("### 입금액 : " + amount);
        balance += amount;

        System.out.println("### 입금 후 잔액 : " + balance);
        System.out.println("### 입금이 완료 되었습니다.");
    }

    // 출금하기
    /**
     * 출금 요구 금액 , 비밀번호를 전달받아 , 인증이 완료되면 요구된 금액만큼 출금액을 반환한다.
     * @param amount 출금 금액
     * @param pwd 계좌 비밀번호
     * @return 출금액수 , 비밀번호가 일치하지 않으면 출금액은 0 원이다
     */
    public int withdraw( int amount ,  int pwd) {
        // 요구 조건인 출금액수와 비밀번호 일치한지 확인
        // 빠르게 종료하기 , 나쁜경우를 먼저 찾아서 제거
        if(password != pwd) {
            System.out.println("### 출금이 실패 했습니다");
            System.out.println("### 비밀번호가 일치하지 않습니다");
            return 0 ;
        }
        balance -= amount;
        System.out.println("### 출금 성공");
        System.out.println("### 출금 후 잔액 "+balance);

        return amount;

    }

    // 비밀번호 변경하기
    /**
     * 이전 비밀번호와 새 비밀번호를 전달받아 비밀번호를 변경한다
     * 이전 비밀번호와 비밀번호가 일치하고 , 새 비밀번호와 이전 비밀번호가
     * 서로 다른경우에만 비밀번호를 변경한다
     * @param oldPwd 기존 비밀번호
     * @param newPwd 변결할 새 비밀번호
     */
    public void changePassword(int oldPwd , int newPwd) {

        if(oldPwd != password) {
            System.out.println("### 비밀번호 변경 실패");
            System.out.println(" 비밀번호가 일치 하지 않습니다.");
            return; // 바로 종료 하단에  "### 비밀번호 변경이 완료 되었습니다") 출력안되게 하고 changePassword 메서드가 종료됨
        }

        if(oldPwd == newPwd) {
            System.out.println("### 비밀번호 변경 실패");
            System.out.println(" 기존 비밀번호와 새 비밀번호가 일치 합니다.");
            return;	// changePassword 메서드가 종료
        }

        password = newPwd;
        System.out.println("### 비밀번호 변경이 완료 되었습니다");

    }

    // 해지 기능
    /**
     * 비밀번호를 전달받아 계좌를 해지 시킨다
     * 해지가 완료되면 해지 환급금을 반환한다
     * @param pwd 입력한 비밀번호
     * @return 해지 환급금액 , 현재 잔액
     */
    public long terminate (int pwd) {
        System.out.println("### 계좌 해지하기");

        // 잔액 amount
        // 이자율 계산 amount * 0.05
        // 해지 환급 최종금액 = 잔액 + 이자율계산 금액

        if(pwd != password) {
            System.out.println("### 비밀번호가 일치하지 않아 해지할수 없습니다.");
            return 0;
        }

        long amount = balance + (long)(balance * interestRate);	// Type mismatch: cannot convert from double to long
        System.out.println("계좌가 성공적으로 해지 되었습니다.");
        return amount;


    }
}


// 은행 계좌 클래스 설계

// - 속성
// ---예금주 String , 계좌번호 String  비밀번호 int  , 잔액 long , 이율 double

// - 기능
// --- 조회
//	예금주 , 계좌번호 , 현재 잔액 화면에 출력
// * 반환 타입 : void
// * 메서드 이름 : display
// * 매개변수 : 없음
// public void display() {}


// --- 입금
//	신규 입금액을 전달받아 잔액을 중가 시킨다
// * 반환 타입 : void
// * 메서드 이름 : deposit
// * 매개변수 : int amount
// public void deposit(int amount){}


// --- 출금
//	출금액 , 비밀번호를 전달받아 인증이 통과되면
//  출금액 만큼 잔액을 감소 시키고 출금액 만큼 금액을 반환한다
// * 반환타입 : int
// * 메서드 이름 : withdraw
// * 매개변수 : int amount , int pwd
// public int withdraw (int amount , int pwd){}


// --- 비밀번호 변경
//	이전 비밀번호 , 사용할 새 비밀번호를 전달받아서
// 	인증이 통과되면 비밀번호를 새 비밀번호로 대체한다
// * 반환 타입 : void
// * 메서드 이름 : changePassword
// * 매개변수 : int oldPwd , int newPwd
// public void changePassword(int oldPwd , int newPwd){}


// --- 해지 기능
//	비밀번호를 전달받아 인증이 통과되면
// 	현재 잔액과 이율을 계산해 최종 해지 예상금액을 반환한다.
// * 반환 타입 : long
// * 메서드 이름 : terminate
// * 매개변수 : int pwd
// public long terminate (int pwd){}
