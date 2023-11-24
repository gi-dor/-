- 파일에 대한 정보가 필요한 경우 데이터베이스에 파일에 대한 정보도 저장하고 파일도 업로드한다
- File객체를 생성하면

        파일명 , 사이즈 , 최종 수정일자.... 등의 정보를 조회할 수 있다

위의 정보를 조회 하기 위해 File 객체를 생성했고 , 스트림 객체 생성할 때도 File 객체를 활용 했다.

        File file = new File("sample.txt");
        file.length();
        file.lastModified();
        FileInputStream in = new FileInputStream(file);

+ 파일에 대한 구체적인 정보가 필요하지 않음
+ 단순히 스트림 객체를 생성할 때 파일명이나 경로만 이용한다

        FileInputStream in = new FileInputStream("sample.txt");