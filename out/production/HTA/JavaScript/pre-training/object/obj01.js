// 책정보를 저장하는 오브젝트 생성하기

let book  = { 
title : '자바의정석',
author : '남궁성',
price : 32000,  // 가격
soldout : false ,  // 품절상태
stock : 5  // 재고량
};

//    title  - > key
//    '자바의정석' -> value

// 오브젝트에 저장된 값을 출력하기
/* 오브젝트에 저장된 값 조회 / 사용하기
참조변수.프로퍼티
참조변수["프로퍼티명"]
*/

console.log("제목 : "+ book.title);
console.log("저자 : " , book.author);
console.log("가격 : ",book.price);
console.log("품절 상태 : ", book["soldout"]);
console.log("재고량 : " , book.stock);
