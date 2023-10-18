function login1(userId , password){
	// 사용자 Id가 없으면 즉시종료
    // id가 없다고 하니 
	if( userId == undefinded){ 
    		console.log("아이디를 입력해주세요");
            return ;  
            }
            
            // 사용자 아이디로 정보 조회
      	let userInfo = getUserInfo(userId);
        // 사용자 정보가 비어있으면 즉시종료 - 아이디와 일치하는 사용자 정보가 없음, 회원가입 안되있단 소리지
        if(userInfo == null){
        	console.log("가입 되어있지 않습니다");
         	return;
            }
            
        // 조회된 비밀번호와 전달받은 비밀번호가 일치하지 않으면 즉시종료
        if(userInfo.password != password){
        	console.log("비밀번호가 일치 하지 않습니다." );
        	return;
            }
            
            // 이 부분의 실행문이 작동하는 경우는 
            // 1. 아이디를 전달받고 
            // 2. 아이디로 조회한 사용자가 정보가 존재하며
            // 3. 비밀번호가 일치하는 경우에만 로그인 성공
            
   }



function login2(userId , password){
    if (userId != undefined){
            let userInfo = getUserInfo(userId);
            if(userInfo != null){
                if(userInfo.password == password){
                    // 로그인 성공함
                    // 이메일 , 쪽지 조회
                    // 홈화면 출력
                }else {
                    console.log("비밀번호 틀림");
                }

            }else {
                console.log("사용자 정보가 존재하지 않습니다");
            }

    } else {
        console.log("아이디를 입력해주세요");
    }
}