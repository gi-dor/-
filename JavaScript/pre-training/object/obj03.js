
// 빈 오브젝트를 생성 하고 정보를 저장하기
// 정보는 이름과 값의 조합


// 성적 정보를 담을 빈오브 젝트 생성
// 학생이름 , 국어 , 영어 , 수학 , 점수 저장하기

let score = {};

score.name = "기선";

score["kor"] = 100;
console.log("성적객체: ", score);

score.eng = 98;
console.log("성적객체: ", score);

score["math"] = 32;
console.log("성적객체: ", score);
console.log("값이 늘어나는 것을 확인할수 있다.");

score.total = score.kor + score.eng + score.math;
score.average = score.total / 3;

console.log("학생 이름 :",score.name);
console.log("총점 : ", score.total);
console.log("평균 : ", score.average);