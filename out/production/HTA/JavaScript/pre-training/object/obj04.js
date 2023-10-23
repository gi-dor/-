// 베스트 셀러 정보를 표현하는 배열 생성하기

let books = [
    {
        title : "트렌드 코리아 2024",
        author : "김난도",
        price : 18000,
        discountRate : 0.1
    },
    {
        title : "퓨처 셀프",
        author : " 벤자민 하디 ",
        price : 19000,
        discountRate : 0.15
    },
    {
        title : "세이노의 가르침",
        author : " 세이노 ",
        price : 7000 ,
        discountRate : 0.1
    }

];

// 배열에 저장된 베스트 셀러 정보 출력하기
for(let index = 0; index < books.length; index++){
   let x = books[index];
//    console.log(x);  // 모든 정보 출력
console.log(x.title , x.price , x.discountRate);
}