
// 배열에 값이 존재하는지 확인하기

let names = ["김유신","김시민","곽재우","한명회","권율"];

// 이름을 입력받아서 배열에 이름이 존재하는지 확인하기


/*
1. 존재 여부를 저장하는 변수 exist를 생성 ㅡ 초기값으로 false주기 
2. 궁극적으로 true인 값을 찾기 위해서 false를 초기값으로 준다고한다.
3. 반복시작
  - 배열의 0 번째부터 값을 조회 
  - names의 값과 value 의 값이 일치하면 exist에 true를 대입한다
  - 반복종료
4. exist 값 출력
 */

let value = "한명회";
let exist = false;

for(let index = 0; index < names.length; index++){
    let name = names[index];
    if(value == name){
        exist = true;
        break;  // 일치 하는 값을 반견한다면 더이상 배열의 값 조사할 필요 없다,
    }
}
console.log("주어진 값이 존재 하는가 ? : ", exist);