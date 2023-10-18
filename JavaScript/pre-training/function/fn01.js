
// 함수 정의하기 
function gugu(dan){
    console.log(dan, "단 을 출력합니다");
 
    for(let i = 1; i <= 9; i++){
        console.log(dan, " * " , i , " = ", dan*i)
    }
    console.log();
    console.log();
};

// 함수 사용하기
gugu(2);   // 인수 2 - 함수를 호출시 2를 gugu()함수에 전달해줌
gugu(3);
gugu(4);
gugu(5);


