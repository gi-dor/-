🔶 InputStream

- FileInputStream - 파일과 연결해서 파일의 내용을 1byte씩 읽어오는 스트림
- BufferedInputStream - 다른 스트림과 연결해서 읽기성능을 향상시키는 스트림
- DataInputStream - 스트림을 읽어서 값을그대로 복원한다
- ObjectInputStream

🔶 OutputStream

- FileOutputStream - 파일과 연결해서 파일에 1byte씩 파일에 기록하는 스트림
- BufferedOutputStream - 다른 스트림과 연결해서 쓰기 성능을 향상시키는 스트림
- DataOutputStream - 값을 데이터 타입 그대로 출력하는 스트림
- ObjectOutputStream
- printStream - 쓰기 전용 스트림 , 표준출력 , 표준 에러출력 스트림이다

🔹 Reader

- FileReader - 파일과 연결해서 파일은 내용을 1글자씩 읽어오는 스트림
- BufferedReader - 다른 스트림과 연결해서 읽기성늘을 향상시키는 스트림
    + 텍스트를 한 줄씩 읽어오는 스트림
    + 텍스트 읽기에 최적화되어있는 스트림
- InputStreamReader - InputStream과 연결 가능한 Reader 객체

🔹 Writer

- FileWriter - 파일과 연결해서 1글자씩 파일에 기록하는 스트림
- BufferedWriter - 다른 스트림과 연결해서 쓰기 성능을 향상시키는 스트림
- OutputStreamWriter - OutputStream가 연결하는
- PrintWriter - 쓰기 전용 스트림 , 텍스트기록에 최적화되어 있는 스트림
    + 한줄씩 출력하는 println() 메서드를 제공
    + 자동 flush 기능도 제공한다