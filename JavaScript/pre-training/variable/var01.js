// JavaScript는 동적 데이터 타입을 지원한다.
// 변수에 저장되는 데이터에 따라 변수의 타입이 달라진다.

let a;
console.log("a의 데이터의 타입 :",typeof(a));

a = false ;
console.log("a의 데이터의 타입 :",typeof(a));

a = 100;
console.log("a 데이터의 타입 :",typeof(a));

a = 3.14;
console.log("a 데이터의 타입 :",typeof(a));

a = "안녕하세요";
console.log("a 데이터의 타입 :",typeof(a));

a = {name : "기선" , kor : 100 , eng : 100 , math :100};
console.log("a의 데이터 타입 : ",typeof(a));

a = function(){
    console.log("함수 입니다.");
}
console.log("a의 데이터 타입 : ",typeof(a));

