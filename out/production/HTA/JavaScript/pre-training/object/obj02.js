
// 다양한 타입의 값( 문자 , 숫자 , boolean , 배열 , 다른 오브젝트)를
// 가지고 있는 오브젝트 생성하기


/*
자동차 판매점에서 관리하는 고객정보
고객이름
나이 
전화번호 
보유차량 - 제조사
*/
let customer = {
    name : "기선",
    age : 30 ,
    tel : "010 - 0000 - 1234",
    car :{
        company : "혼다",
        model : "슈퍼커브",
        year : 2022 ,
        price : 2550000
    } 
}

console.log("고객명 : ",customer.name);
console.log("나이 :",customer.age);
console.log("전화번호 : ",customer.tel);
console.log("보유 차량 제조사:",customer.car.company)
console.log("보유차량 모델 :",customer.car.model);
console.log("보유차량 연식 :",customer.car.year);