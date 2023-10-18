// 다양한 유형의 매개변수


// 숫자값을 인자로 전달받는 함수    
// 숫자 2개를 전달받아서 더 큰값을 반환한다.
function max(num1, num2){
    if(num1 > num2){
        return num1;
    }
    // 위에 if문에 조건이 false 일경우 여기 까지 와서 num2 가 반환된다.
    return num2;
}

let max1 = max(20,70);
let max2 = max(60,25);

console.log("큰 값:",max1);
console.log("큰 값:",max2);

// 문자값을 인자로 전달받는 함수
// 매개변수에는 문자값이 저장된다.
// 이름을 전달받아 두번째 글자를 "*" 로 변환한 문자를 반환 한다.


 // name 문자열의 각 글자를 배열로 변환합니다.
 // 예: "한기선" -> ["한", "기", "선"]
// 변환된 배열의 각 요소(글자)와 해당 요소의 인덱스에 대해 함수를 실행
// 만약 현재 요소의 인덱스가 1이라면 (즉, 두 번째 글자라면)
// '*'를 반환합니다.
// 인덱스가 1이 아닌 경우, 원래의 글자를 반환합니다.
// 배열의 요소들을 다시 문자열로 합칩니다.
// 예: ["한", "*", "선"] ->  "한*선" 

   function hideName(name){
   return name.split("").map(function(value,index){
        if(index == 1){
            return "*";
        }
        return value;
    }).join ("");
}

console.log(hideName("한기선"));
console.log(hideName("깃허브"));

// 배열을 인자로 전달받는 함수
// 배열객체를 참조하는 주소값을 전달받음
// 주소값을 전달받을 매개변수도 주소값에 해당하는 배열객체를 


function sum(arr){
    let total = 0;
        for(let index = 0; index < arr.length; index++){
            total += arr[index];
        }
        return total;
}

let numbers = [10,20,40,60,70,80];
let sumResult = sum(numbers);
console.log("sumResult",sumResult);


let sumResult2 = sum([30,30,20,30]);
console.log("sumResult2",sumResult2);


// 객체를 인자로 전달받는 함수