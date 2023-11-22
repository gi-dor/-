//package Java.exception.exception3;
//
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//public class App1 {
//
//
//     // 예외의 변환
//
//    // 메서드에서 발생하는 FileNotFountException, IOException을
//    // try catch 문을 사용해서 잡고 HtaException을 발생 시켰다
//    public static String readfile() {
//        try{
//                BufferedReader reader = new BufferedReader(new FileReader("sample.txt"));
//                String text = reader.readLine();
//
//                return text;
//            } catch ( FileNotFoundException ex ) {
//                throw  new HtaException("sample.txt",ex);
//            } catch (IOException ex) {
//
//                throw new HtaException(ex);
//            }
//
//        }
//
//        /*
//        예외의 변환
//        ` 메서드에서 발생하는 예외를 잡고 - catch , 대신 다른 예외 발생 throw new Exception
//        ` 예외를 일괄 처리하는 곳에서 처리할 예외의 종류를 줄일 수있다
//        $ 메서드에서 발생하는 다양한 예외를 일괄처리하는 곳으로 throws 로 위임하는 대신
//          사용자 정의 예외를 대신 발생 시킴으로 써 일괄 처리하는 대상예외를 사용자 장의 예외로 한정시킨다
//         */
//
//    public static Date toDate(String text) throws ParseException {
//       try{
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = sdf.parse(text);
//
//        return date;
//
//       } catch ( ParseException ex) {
//           throw new HtaException(text , ex);
//       }
//    }
//
//    public static void signIn(User user) {
//        User savedUser = userRepo.findById(user.getId());
//        if(savedUser != user) {
//            throw new HtaException("["+user.getId()+"] 는 이미 사용중입니다");
//        }
//    }
//
//
//    public static void main(String[] args) {
//
//        try{
//           String str = readfile();
//            System.out.println("읽어온 텍스트 : " +str);
//
//            toDate("2024-01-20");
//            signIn(new User("Han" ,"1q2w3e4r" , "기선"));
//        } catch () {
//            throw new HtaException();
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//}
