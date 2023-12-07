JDBCTemplate

- JDBC를 활용한 데이터 베이스 엑세스 작업을 도와주는 기능이 구현된 클래스

주요 메서드

    int insert(String sql)
    int insert(String sql , Object....params)

    int update(String sql)
    int update(String sql ,Object.....params)

    int delete(String sql)
    int delete(String sql ,Object.....params)

----

📌 Object... params  <br><br>
매개변수가 있는 메서드는 SQL의 바인딩 변수인 (?) 가 있을 때 사용하는 메서드

Object... params 에 해당하는 부분에 ? 와 치환 될 값을 순서대로 나열하면 된다

▶ 작성 예시

        public void insertBook(Book book) {

            String sql =  """
                insert into sample_book 
                        (book_no , book_title , book_price , book_stock)
                values
                        (?,?,?,?)
                """;

             JdbcTemplate.insert(sql,
                                book.getNo(),
                                book.getTitle(),
                                book.getPrice(),
                                book.getStock()
                                    );
        }

---
<br>

        T selectOne(String sql , RowMapper<T> rowMapper);
        T selectOne(String sql , RowMapper<T> rowMapper,Object... params);
        

        List<T> selectList(String sql , RowMapper<T> rowMapper);
        List<T> selectList(String sql , RowMapper<T> rowMapper,Object... params);

🔹 selectOne 메서드는 조회 결과가 한건 조회 될 때 사용 <br>
🔹 selectList 메서드는 조회결과가 여러건 조회 될 때 사용

📌 selectOne 메서드는 기본키 컬럼이 WHERE 절의 조건식에 포함되어 있을 때 사용한다

🔹 RowMapper<T> 는 인터페이스다 <br><br>
RowMapper는 SQL쿼리 결과를 Java 객체로 변환 하는데 쓰인다
DB로부터 얻은 각 행을 Java 객체로 변환 할것인지 정의하는 인터페이스 ?

▶ 매개변수에 인터페이스가 있다면 나에게 알려줘 라는 뜻..?

            interface RowMapper<T> {
                T mapRow(ResultSet re ) throws SQLException;
                // 메서드에 Map ?
                // 입력을 T로 ?
            }

        select book_no , book_title , book_price 
        from sample_books;

        ------------------------
        100  자바의정석    10000  → Book
        ------------------------
        102  이것이 자바다  20000 → Book
        -----------------------
    
        public book getBookByNo (int no ) {
            String sql = """
                select book_no , book_title , book_price
                from sample_books
                where book_no  = ?
                """;
            
            JdbcTemplate.seleOne(sql, new RowMapper<Book>() {
                public Book mapRow(ResultSet rs) throws SQLException {
                    Book book = new Book();
                    book.setNo(rs.getInt("book_no") );
                 
                    return book;
                        }
                              }, no);     
            
                    }
                    
            JdbcTemplate.selectOne(sql, rs-> {
        Book book = new book();      
        book.setNo(rs.getInt("book_no"));
                
            return book;
            }, no);
        }
        