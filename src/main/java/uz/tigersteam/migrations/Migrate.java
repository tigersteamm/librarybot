package uz.tigersteam.migrations;

import uz.tigersteam.config.DbConfig;
import uz.tigersteam.config.PConfig;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * @author Nodirbek Abdukarimov Fri. 10:01 AM. 12/24/2021
 */
public class Migrate {
    public static void init() {
        try (FileReader fileReader = new FileReader(PConfig.get("db.migrations.path"));
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             Statement s = DbConfig.conn().createStatement();
        ) {
            String queryDATA = bufferedReader.lines().collect(Collectors.joining());
            StringTokenizer queries = new StringTokenizer(queryDATA, ";");
            while (queries.hasMoreTokens())
                s.addBatch(queries.nextToken());
            s.executeBatch();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
