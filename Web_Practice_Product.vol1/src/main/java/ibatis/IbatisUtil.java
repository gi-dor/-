package ibatis;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import java.io.IOException;
import java.io.Reader;

/**
 * ibatis 의 핵심 객체 (SqlMapClient 객체)를 제공하는 유틸 클래스 SqlMapClient 객체는 Insert , Update , Delete ,Select 기능을 제공하는 객체
 */

public class IbatisUtil {
    /**
     * ibatis 핵심 객체를 저장하는 정적변수
     */
    private static SqlMapClient sqlMapClient;

    /**
     * 클래스가 메모리에 로딩될 때 수행될 수행문을 포함하고 있는 정적 초기화 블럭
     * ibatis 환경설정 파일을 읽어오는 Reader 객체를 생성한다.
     * ibatis 핵심객체를 생성해서 정적변수에 대입한다.
     */
    static {
        try {
            Reader reader = Resources.getResourceAsReader("ibatis/config.xml");
            sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * ibatis 핵심객체 (SqlMapClient 객체)를 반환
     *
     * @return SqlMapClient 객체
     */
    public static SqlMapClient getSqlMapClient() {
        return sqlMapClient;
    }


}
