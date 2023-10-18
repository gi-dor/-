/*
국어 영어 수학 점수를 전달받아서 총점을 반환하는 함수다.
함수명 : totalScore
매개변수: kor , eng , math 각각 국어 , 영어 , 수학점수를 뜻한다
반환 값 : 총점

*/
function totalScore(kor,eng,math){
    let total = kor + eng + math;

    return total;
}

function averageScore(kor,eng,math){
    // totalScore 함수를 실행해 총점을 반환함 ( 총점 계산 안해도됨 )
    let total = totalScore(kor,eng,math);
    let average = total / 3;
    
    return average;
}


// 총점
console.log("총점 계산하기");
let result1 = totalScore(70,60,90);
let result2 = totalScore(100,90,60);
let result3 = totalScore(90,60,50);

console.log("첫번째 총점 : ",result1);
console.log("두번째 총점 : ",result2);
console.log("세번째 총점 : ",result3);



// 평균
console.log()

let avg1 = averageScore(70,60,90);
let avg2 = averageScore(100,90,60);
let avg3 = averageScore(90,60,50);

console.log("첫번째 평균 :",avg1);
console.log("두번째 평균 :",avg2);
console.log("세번째 평균 :",avg3);