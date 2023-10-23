function plus(num1,num2){
    let result = num1 + num2;
    console.log("덧셈결과 : ", result);
    console.log();
}

function minus(num1,num2){
    let result = num1 - num2;
    console.log("뺄셈 결과 : ", result);
    console.log();
}

operator(100 , 200 , plus);
operator(100 , 200 , minus);
operator(100,200,function(x,y){
    let result = x * y ;
    console.log(
        "곱셈결과 : ",result
    )}
)
operator(100,10,divide);

function divide(num1,num2){
    let result = num1 / num2;
    console.log("나누기 결과 :", result);
}

// 매개변수로 다른 함수를 전달받는 함수

/* 
함수를 매개변수의 인자로 전달하는 목적은 
호출되는 함수(operator)가 구체적으로 실행할 기능(fn)을 
전달 하려는 것이 목적

호출되는 함수는 구체적인 구현을 하지않고
전달받는 기능을 실행하기만 하면된다.


*/
function operator(value1 , value2 , fn){
    fn(value1, value2);
}

/* 위와 같이 사용하는 이유
- 일반적으로 많은 기능들은 변하지 않는 부분과 매번 변하는 부부은 코드가 구성도더미
- 변하지 않느 기능은 함수내에서 직접구현
- 매번 변하는 기능은 외부로부터 실행할 기능을 전달받는다
- 아래 함수에서 매개변수의 콜백함수는 실제로 실행할 기능(매번 변하는기능)이
구현된 함수로 전달받는다.



function함수 (매개변수1 , 매개변수2 , 콜백함수){
   
    // 함수 기능중에서 변하지 않는부분
    수행문1;
    수행문2;
    수행문3;

    // 함수 기능중에서 매번 변하는부분
     콜백함수();


    // 함수 기능 중에서 변하지 않는 기능
    }

*/