package uz.tigersteam.repository;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Nodirbek Abdukarimov Fri. 5:54 PM. 12/24/2021
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LogRepository extends AbstractRepository {
    private static final LogRepository instance = new LogRepository();


    public void save(String data) {
        query.append("insert into logs (log) values (?);");
        getPreparedStatement(data);
        executeWithout();
    }

    public static LogRepository getInstance() {
        return instance;
    }
}
