// break문을 이용해 반복문 탈출하기

// 1 ~ 100 까지 더해 갈 때 , 그 합계가 2000을 넘을 때 숫자를 출력

let num;
let total = 0;
let max;

for(let num = 1; num <= 100; num++){
    total += num;

if(total > 2000){
    max = num;    
    break;
    }
}
console.log("멈추는 숫자 : "+max);
console.log("합계 : "+total);
