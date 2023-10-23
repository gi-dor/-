// 배열의 값 탐색하기
// 최대값 , 최소값 구하기

let arr = [27 , 23, 32, 645, 152 ,65 ,12 , 4];

// 배열의 저장된 값 중에 최대값

/* 
1. 최대값을 저장하는 변수 max 생성하고 배열의 0번째 값을 저장한다
2. 반복문
  배열에서 index 번째의 값을 조회해서 변수 num에 대입한다
  비교 연산자를 이용해 num > max를 수행해서 true 로 판정되면
  num의 값을 max에 대입하기
  
3. 반복문 종료 이후 최대값 출력하기   
 */

let max = arr[0]; // 첫번째 값이 제일 크다가 일단 가정하자

for(let index = 1; index < arr.length; index++){
    let num = arr[index];
    if(num > max){
        max = num;
    }
}
console.log("최대값 max :",max);



// 배열의 저장된 값 중에 최소값
/*
1. 최소값을 저장할 변수 min 생성 그 값은 배열의 0 번째 값 arr[0]으로 설정
2. 반복문 사용
    배열에서 index 번쨰 값을 조회해서 변수 num에 대입하는데
    비교 연산자를 사용해 num < min 이라면
    그 값을 min에 대입한다
    (num < min 이라면 최소값 min 저장된 값보다 
        이번에 찾은 배열의 값이 더 작다는 
        소리이니 min 에다가  num 값을 대입)
3. 반복문 종료후 최소값 출력하기
*/

let min = arr[0];
for(let index = 1; index < arr.length; index++){
    if(arr[index] < min){
        min = arr[index];
    }
}
console.log("최소값 min :",min);
