
// 로또 번호 출력하기

/*
Math.random()  = 0 보다 크거나 같고 1보다 작은 임의의 실수를 반환한다.
Math.trunc(실수) = 실수의 소수점 부분을 버려 정수로 반환한다

let value = Math.trunc(Math.random() * N + 1);
value의 값은 1  ~ N 범위의 정수값이다

*/

// 1 ~ 45 범위의 임의의정수 6개를 저장할 배열객체다.


function generateLotto(){
    
    let lotto = [];

    while(true){

        // 임의의 정수값 얻기
        let number = Math.trunc(Math.random() * 45 + 1);
        
        // 존재여부를 체크해서 존재하지 않으면 배열에 추가한다.
        let result = exists(lotto,number);
        
        if(result == false){
        // 배열에 값 추가하기
            lotto.push(number);
        }

        if(lotto.length == 6){
            break;
        }
    }

    lotto.sort(function(num1,num2){
        return num1 - num2
    });
    console.log("로또번호 : ", lotto);
}

function exists(arr,number){
    // 존재 여부를 저장할 변수 정의
    let isExists = false;
    // 배열의 길이만큼 반복작업을 수행
    for(let index = 0; index < arr.length; index++){
        // 인덱스번째 배열값과 전달받은 숫자를 비교
        // 값이 일치하면 존재여부를 true로 설정 , 반복문을 탈출
            if(arr[index] == number){
                isExists = true;
                break;
            }
        }
        // 존재여부를 반환한다.
        return isExists; 
    }


for(let i = 1; i<=5; i++){
   generateLotto();
}
// generateLotto();
