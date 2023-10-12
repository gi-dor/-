/*
if(조건식) {
    수행할 문장;

}
*/

// 평균 점수가 60점 이상이면 합격이다
let kor = 80;
let eng = 60;
let math = 65;

let total = kor + math + eng;

let average = total / 3;

if(average >= 60) {
    console.log("합격 입니다");
    console.log("최종점수 :",average);
    }else {
        console.log("불합격 입니다");
        console.log("최종 점수 : ",average);
    }