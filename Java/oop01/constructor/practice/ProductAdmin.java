package Java.oop01.constructor.practice;

import Java.oop01.constructor.Scanner;

public class ProductAdmin {
    public static void main(String[] args) {

        // 제품 등록 , 수정
        int updateProduct = 0;

        // 상품 등록해둘 배열

        // 제품 30개 등록 할수 있음.
        ProductEx[] pd = new ProductEx[30];

        // 번호 , 이름 , 제조사 , 가격 , 갯수
        pd[0] = new ProductEx(1 , "윈도우 10" , "마소" , 90 , 10);
        pd[1] = new ProductEx(2 , "윈도우 97" , "마소" , 50 , 10);
        pd[2] = new ProductEx(3 , "윈도우 98" , "마소" , 60 , 10);
        pd[3] = new ProductEx(4 , "윈도우 xp" , "마소" , 70 , 10);
        pd[4] = new ProductEx(5 , "윈도우 vista" , "마소" , 80 , 10);
        pd[5] = new ProductEx(10 , "모니터" , "삼성" , 40 , 10);
        pd[6] = new ProductEx(11 , " 티비" , " LG  " , 50 , 10);
        pd[7] = new ProductEx(12 , "키보드" , "한성" , 20 , 10);
        pd[8] = new ProductEx(13 , "마우스" , "로지텍" , 5 , 10);

        Scanner scanner = new Scanner(System.in);

        // 제품 종료를 하기전까지 계속 해서 반복 하게 하려고 true
        while(true) {
            System.out.println("-------------------------------------------------");
            System.out.println("1.제품 조회  2.제품 등록   3.제품검색  4.정보수정  5.삭제  0.종료");
            System.out.println("-------------------------------------------------");

            System.out.println("메뉴를 선택하세요");
            int menuNo = scanner.nextInt();

            if(menuNo == 1) {
                System.out.println("<===================== 전체 상품 조회 ====================>");
                for(ProductEx value : pd) {
                    if(value == null) {
                        break;
                    }
                    System.out.printf("%2d %-20s %-20s %5d만원 \n", value.no , value.name , value.maker , value.price  );
                }
            } else if (menuNo == 2) {

                // 제품 번호, 이름 , 제조사 , 가격 , 입고수량 입력받기
                // 입력된 정보를 ProductEx 객체에 저장
                System.out.println("<===================== 제품 등록 페이지 ====================>");
                System.out.println("##### 신규 상품 정보를 입력하세요");

                System.out.print("제품 번호 입력 : ");
                int no = scanner.nextInt();

                System.out.print("제품 이름 입력 : ");
                String name = scanner.nextString();

                System.out.print("제품의 제조사 등록 : ");
                String maker = scanner.nextString();

                System.out.print("제품의 가격 등록 : ");
                int price = scanner.nextInt();

                System.out.print("제품 입고 수량 등록 : ");
                int stock = scanner.nextInt();

                // 입력받은 값을 객체를 만들어서 저장하기
                // ProductEx 클래스에서
                // 멤버변수 soldOut에 값을 false로 주는 생성자를 만들어뒀기에
                // scanner를 통해 true false를 주지않아도 되서
                // 객체 생성시 boolean soldOut을 주지않았음

                ProductEx subSave = new ProductEx(no , name , maker, price , stock);

                pd[updateProduct++] = subSave;
                System.out.println();
                System.out.println("### 상품이 등록 되었습니다");




            } else if (menuNo == 3) {
                // 상품 정보를 검색하기
                // 검색 옵션 받기
                // 1. 상품번호로 검색
                // 2. 상품이름으로 검색
                // 3. 제조사로검색
                // 4. 가격을 검색
                // 검색 옵션에 맞는 검색 입력방법 받기
                // for each로 처음부터 끝까지 반복해서 검색

                System.out.println("<===================== 상품 검색 하기 ====================>");
                System.out.println("### 검색 옵션을 선택하세요 (1.번호 2. 이름 3.제조사 4.가격");
                int searchOpt = scanner.nextInt();	// 입력받은 값을 searchOpt 변수에 담음

                switch (searchOpt) {
                    case 1:
                        System.out.println(" ### 상품 번호로 검색하기 ");
                        System.out.print(" ### 검색할 상품번호 입력 : ");
                        int no = scanner.nextInt();
                        for(ProductEx pdex : pd) {
                            if(pdex == null) {
                                break;
                                // null뜨면 멈춰버리게 break;
                            }
                            if(pdex.no == no) {
                                pdex.printProductEx();
                            }
                        }
                        break; // 완료 되었으면 멈춰야지 안그러면 다음 case까지 넘어감

                    case 2:
                        System.out.println(" ### 상품 이름으로 검색하기");
                        System.out.print(" ### 검색할 상품 이름 입력하세요 : ");
                        String name = scanner.nextString();

                        for(ProductEx pdEx : pd) {
                            if(pdEx == null) {
                                break;
                            }
                            if(pdEx.name.equals(name)) {
                                pdEx.printProductEx();
                            }

                        }
                        break;

                    case 3:
                        System.out.println(" ### 제조사로 검색하기");
                        System.out.print(" ### 검색할 제소사를 입력하세요 :");
                        String maker = scanner.nextString();

                        for(ProductEx pdEx : pd) {
                            if(pdEx == null) {
                                break;
                            }
                            if(pdEx.maker.equals(maker)) {
                                pdEx.printProductEx();
                            }
                        }
                        break;

                    case 4:
                        System.out.println(" ### 가격으로 검색하기");
                        System.out.println(" ### 검색할 가격을 입력하세요");

                        System.out.print(" ### 최저가 입력 : ");
                        int minPrice = scanner.nextInt();

                        System.out.print(" ### 최대가 입력 : ");
                        int maxPrice = scanner.nextInt();

                        for(ProductEx pdEx : pd) {
                            if (pdEx == null) {
                                break;
                            }
                            if(pdEx.price >= minPrice && pdEx.price <= maxPrice) {
                                pdEx.printProductEx();
                            }
                        }
                        break;
                }



            } else if (menuNo == 4) {

            } else if (menuNo == 5) {

            } else if (menuNo == 0) {
                System.out.println(" <========== 관리자 프로그램 종료 ==========>");
                System.exit(0);
            }


            break;

        }

    }
}
