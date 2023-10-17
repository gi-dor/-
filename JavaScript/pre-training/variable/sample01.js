// 변수 생성 및 초기화
let score = 100;

// 합격 기준은 점수가 60점 이상
// 변수에 저장된 값이 합격 기준에 맞는지 결정하기

let result = score >= 60;

// 합격여부 출력하기
console.log(result);

//  회원의 가입한 비밀번호 
let dbPassword = "zxcv1234";

// 사용자가 입력한 비밀번호를 저장하는 변수 선언 초기화
let inputPassWord = "zxcv1234";

// 비밀번호 일치여부 결정하기
result = dbPassword == inputPassWord;

// 비밀번호 일치여부 출력
console.log("비밀번호 일치 여부 :",result);
