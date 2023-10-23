// 속성과 기능을 모두 포함하는 객체

let score1 = {
    // 속성 property
    name : "기선",
    kor : 67,
    eng : 55,
    math : 60,

    // 기능 method
    getTotal: function(){
        let total = this.kor + this.eng + this.math;
        return total;
    },
    getAverage : function(){
        let average =this.getTotal() / 3;
        return average;
    },
    print : function(){
        console.log("--- 성적 정보 ---");
        console.log("이름 : ",this.name);
        console.log("국어 : ",this.kor);
        console.log("영어 : ",this.eng);
        console.log("수학 : ",this.math);
        console.log("총점 : ",this.getTotal());
        console.log("평균 : ",this.getAverage());
    }
}

// print()를 호출한 객체의 주소 값 ?
score1.print();


console.log(score1);


// let total1 = score1.getTotal();
// console.log("총점 : ",total1);

// let average1 = score1.getAverage();
// console.log("평균 : ", average1);