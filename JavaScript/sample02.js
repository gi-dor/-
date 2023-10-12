// 논리 곱의 활용
// 자동차의 무상수리 기준은 보유기간이 3년 미만이고 주행거리고 5만km 이하다.

// 기준
let year = 3;
let distance = 50000;

// 구매년도 , 실제 주행거리
let orderYear = 2021;
let driveDistance = 39999;

// 보유기간 , 운행거리
let isFree = ((2023 - orderYear) < year) && (driveDistance <= distance);
console.log("무상수리 여부 : ",isFree);




// 논리 합의 활용
// 백화점의 커피 쿠폰을 제공하려고 한다
// 신규 고객은 구매금액과 상관없이 지급하고 , 기존 고객은 10만원 이상 구매 한 경우에만 제공한다

// 커피 쿠폰 뿌리는 조건
let customerType = "New";
let price = 100000;  // 구매한 금액

// 현재 쿠폰 받을 내 입장
let myCustomerType = "New";
let myOrderPrice = 0;


let coffeeCoupon = myCustomerType == customerType || myOrderPrice == price;

console.log("커피쿠폰 받을수 있을까? :",coffeeCoupon);

let age = 30;
let beverge = age >= 20 ? "beer" : "juice"
console.log(beverge);


// 삼항연산자

// 점수가 60점 이상이라면 '합격' 그 외에는 '불합격'
let score = 70;
let result = score >= 60 ? "합격" : "불합격";

console.log('시험결과 :',result);