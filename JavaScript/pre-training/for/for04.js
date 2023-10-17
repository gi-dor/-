
// 구구단 출력하기

/*
2 * 1 = 2
2 * 2 = 4
2 * 3 = 6
.....
2 * 9 = 18
*/

let dan;
let i;

for(let dan = 2; dan <= 9; dan++){
    console.log(dan+"단")
    for(let i = 1; i <= 9; i++){
        console.log(dan + " * " + i + " = " + dan*i);
    }
    console.log();
}
