package uz.tigersteam.services;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import uz.tigersteam.mappers.BaseMapper;
import uz.tigersteam.repository.LogRepository;

/**
 * @author Nodirbek Abdukarimov Fri. 10:05 AM. 12/24/2021
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LogService extends AbstractService<LogRepository, BaseMapper> {
    private static final LogService instance = new LogService(LogRepository.getInstance());

    private LogService(LogRepository repository) {
        super(null, repository);
    }

    public void save(String data) {
        repository.save(data);
    }


    public static LogService getInstance() {
        return instance;
    }
}

