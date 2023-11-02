package Java.oop01.constructor;


public class ProductManager {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int savePosition = 0;

        // 상품정보를 여러개 저장하는 배열
        Product[] db = new Product[100];
        db[0] = new Product(100 , "아이폰15" , "애플" , 150 , 3);
        db[1] = new Product(101 , "아이폰15 Pro" , "애플" , 170 , 3);
        db[2] = new Product(111 , "맥북 프로" , "애플" , 350 , 3);
        db[3] = new Product(115 , "아이패드" , "애플" , 200 , 3);
        db[4] = new Product(116, "아이패드 Pro" , "애플" , 250 , 3);
        db[5] = new Product(117 , "갤럭시 플립" , "삼성" , 120 , 3);


        while(true) {
            System.out.println("================================================================");
            System.out.println("1. 전체 조회 2. 신규등록 3. 검색 4. 수정  5. 삭제  0. 종료");
            System.out.println("=================================================================");


            System.out.println("메뉴틑 선택 하세요");
            int menuNo = scanner.nextInt();
            // 전체 상품조회

            // db 배열에 저장된 모든 상품 정보를 출력
            // for each 문을 사용해 배열에 처음부터 끝까지 반복
            // null 이 저장되어있다면 반복 정지

            if(menuNo == 1) {
                System.out.println("<< 전체 상품 조회 >>");

                for(Product p : db) {
                    if(p == null) {
                        break;
                    }
                    System.out.printf("%3d %-15s %-10s %-5d만원\n", p.no , p.name , p.maker , p.price);
                }

            } else if (menuNo == 2) {
                // 신규 상품 등록
                // - 상품 번호 이름 제조회사 가격 입고수량을 입력받는다
                // - Product 객체를 생성해 입력된 상품 정보를 Product 객체에 저장
                // - 상품 정보가 저장된 Product 객체를 배열에 저장
                System.out.println("<< 상품 신규 등록 >>");
                System.out.println("### 신규 상품 정보를 입력하세요");

                System.out.print("### 상품 번호 입력 : ");
                int no = scanner.nextInt();

                System.out.print("### 상품 이름 입력 : ");
                String name = scanner.nextString();

                System.out.print("### 제조 회사 입력 : ");
                String maker = scanner.nextString();

                System.out.print("### 상품 가격 입력 : ");
                int price = scanner.nextInt();

                System.out.print("### 입고 수량 입력 : ");
                int stock = scanner.nextInt();

                Product product = new Product(no , name , maker , price , stock);


                db[savePosition++] = product;

                System.out.println("### 신규 상품이 등록 되었습니다");



                // 입력된 값 배열에 저장하기
            } else if (menuNo == 3) {
                // 상품정보 검색
                // - 검색옵션 입력받는다
                // - 검색옵션은 1 , 2 , 3 중에 하나를 입력받음
                // 1. 상품번호로 검색
                // 2. 상품이름으로 검색
                // 3. 제조사로검색
                // 4. 가격을 검색
                // - 검색 옵션에 맞는 검색어를 입력받는다
                // - for each문으로 배열에 처음부터 끝까지 반복하면서 검색

                System.out.println("<< 상품 정보 검색 >>");

                System.out.print("### 검색옵션을 선택하세요 ( 1: 번호 , 2: 이름 , 3: 제조사 , 4: 가격 )");
                int optNo = scanner.nextInt();

                switch (optNo) {
                    case 1:
                        System.out.println("### 상품 번호로 검색하기");
                        System.out.println("###검색할 상품번호 입력 : ");
                        int no = scanner.nextInt();
                        // nullPoint Exception  발생해서 break; 걸음
                        for(Product product : db) {
                            if(product == null) {
                                break;
                            }

                            if(product.no == no) {
                                product.printProduct();
                            }
                        }

                        break;
                    case 2:
                        System.out.println("### 상품 이름으로 검색하기");
                        System.out.print("### 검색할 상품이름 입력 : ");
                        String name = scanner.nextString();


                        for(Product product : db) {
                            if(product == null) {
                                break;
                            }
                            if(product.name.equals(name)) {
                                product.printProduct();
                            }
                        }
                        break;
                    case 3:
                        System.out.println("### 제조사로 검색하기");
                        System.out.print("###검색할 제조사 입력 : ");
                        String maker = scanner.nextString();
                        for(Product product : db) {
                            if(product == null) {
                                break;
                            }
                            if(product.maker.equals(maker)) {
                                product.printProduct();
                            }
                        }
                        break;
                    case 4:
                        System.out.println("### 가격으로 검색하기");
                        System.out.println("### 검색할 가격 입력 : ");

                        System.out.println("### 최저 가격 입력 : ");
                        int minPrice = scanner.nextInt();

                        System.out.println("### 최고 가격 입력 : ");
                        int maxPrice = scanner.nextInt();

                        for(Product product : db) {
                            if(product == null) {
                                break;
                            }
                            if(product.price >= minPrice && product.price <= maxPrice) {
                                product.printProduct();
                            }
                        }
                        break;
                }


            } else if (menuNo == 4) {
                // 상품 정보 수정하기
                /*
                 * 수정할 상품의 제품번호를 입력받는다
                 * 번호에 해당하는 상품의 모든정보를 찾는다
                 * 검색된 상품정보를 화면에 출력한다
                 *
                 * 상품명 , 가격 , 수량을 입력받는다
                 * 위에서 검색한 상품정보의 상품명 , 가격 , 수량을 변경한다
                 *
                 */
                System.out.println("<< 상품 정보 수정 >>");
                System.out.print("### 수정할 상품의 번호를 입력하세요 :");
                int no = scanner.nextInt();

                Product origin = null;
                for(Product product : db) {
                    if(product == null) {
                        break;
                    }
                    if(product.no == no) {
                        origin = product;
                        break;
                    }
                }
                if(origin == null) {
                    System.out.println("### 상품번호에 해당하는 상품정보가 없습니다.");
                } else {
                    System.out.println("### 수정할 상품 번호를 확인하세요");
                    origin.printProduct();

                    System.out.println("### 이름 , 가격 , 수량정보를 입력해 상품정보를 변경하세요");

                    System.out.print("### 상품 이름 입력 : ");
                    String name = scanner.nextString();

                    System.out.print("### 상품 가격 입력 : ");
                    int price = scanner.nextInt();

                    System.out.print("### 상품 수량 입력 : ");
                    int stock = scanner.nextInt();


                    origin.name = name;
                    origin.price = price;
                    origin.stock = stock;

                    System.out.println("### 상품정보 수정이 완료 되었습니다.");

                }

            } else if (menuNo == 5) {
                System.out.println("<< 상품 정보 삭제 >>");

            } else if (menuNo == 0) {
                System.out.println("<< 프로그램 종료 >>");
                System.exit(0);
            }

            System.out.println();
            System.out.println();
        }


    }

}
