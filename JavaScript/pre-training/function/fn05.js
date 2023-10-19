
// 객체를 인자로 전달받는 함수
function check(score){
    let total = score.kor + score.eng + score.math;
    let average = total / 3;

    // 60점 이상이면 합격
    // 그외에는 불합격
    if(average >= 60){
        return "합격" ;
    }else {
        return "불합격";
    }
}

// 객체 자체를 인자,인수로 받아서 score1에 저장
// passed1변수는 check함수를 score1객체를 인자로 호출해  return으로 반환
let score1 = {kor:100 , eng:100 , math:100};
let passed1 = check(score1);
console.log("첫번째 시험 결과 : ",passed1);

// check함수에 직접 바로 객체 인자를 주고 passed2 에 저장
let passed2 = check({kor:80 , eng: 60 ,math:40});
console.log("두번째 시험결과 : ",passed2);

// 위에 것과 다른점은 줄바꿈 밖에 없음
// 가독성 보기 좋으라고 줄바꿈 사용함
let passed3 = check({
    kor : 70,
    eng : 90,
    math :60
})
console.log("세번째 시험결과 : ",passed3);


