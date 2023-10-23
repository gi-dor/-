/*
소득세
천만원 이상 : 40%
500만원 이상 : 25%;
300만원 이상 : 10%
200만원 이상 : 5%
그외 : 2%
*/


let 급여 = 350;
let 소득세;
let 실수령액;

if(급여 >= 1000){
    소득세 = 급여*0.4;
} else if(급여 >= 500){
    소득세 = 급여*0.25;
} else if(급여 >= 300){
    소득세 = 급여 * 0.1;
} else if(급여 >= 200){
    소득세 = 급여 * 0.05;
}else {
    소득세 = 급여 * 0.02;
}

실수령액 = 급여 - 소득세;

console.log("급여 :",급여);
console.log("세금 :"+소득세);
console.log("실수령 액 :"+실수령액);
