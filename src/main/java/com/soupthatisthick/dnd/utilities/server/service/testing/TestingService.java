package com.soupthatisthick.dnd.utilities.server.service.testing;

import com.soupthatisthick.dnd.utilities.server.data.jpa.repository.AllyRepository;
import com.soupthatisthick.dnd.utilities.server.data.jpa.repository.EncounterRepository;
import com.soupthatisthick.dnd.utilities.server.data.jpa.repository.EnemyRepository;
import com.soupthatisthick.dnd.utilities.server.service.common.base.ErrorCode;
import com.soupthatisthick.dnd.utilities.server.service.testing.model.EchoRequest;
import com.soupthatisthick.dnd.utilities.server.service.testing.model.LogMessageRequest;
import com.soupthatisthick.dnd.utilities.server.service.testing.model.exception.TestingServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;

import static com.soupthatisthick.dnd.utilities.server.util.logger.Logger.LOG;

/**
 * Created by Owner on 9/9/2017.
 */
@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
@Transactional(readOnly = true)
public class TestingService {

    @Autowired
    private EncounterRepository encounterRepository;
    @Autowired
    private AllyRepository allyRepository;
    @Autowired
    private EnemyRepository enemyRepository;

    @Transactional
    public void logMessageRequest(@NotNull LogMessageRequest request) throws TestingServiceException {

        switch(request.getLogLevel()) {
            case INFO:
                LOG.info(request.getMessage());
                break;
            case DEBUG:
                LOG.debug(request.getMessage());
                break;
            case WARNING:
                LOG.warning(request.getMessage());
                break;
            case ERROR:
                LOG.error(request.getMessage(), null);
                break;
            default:
                throw new TestingServiceException(ErrorCode.TESTING_LOG_LEVEL_REQUIRED, "Log level is required.");

        }

    }

    @Transactional
    public void wipeDatabase() throws TestingServiceException {
        LOG.info("Wiping the database.");

        try {
            allyRepository.deleteAllInBatch();
            enemyRepository.deleteAllInBatch();
            encounterRepository.deleteAllInBatch();
        } catch (Exception e) {
            throw new TestingServiceException(ErrorCode.TESTING_WIPE_DATABASE_FAILED, "Failed to clean the repositories.");
        }
    }

    @SuppressWarnings("EmptyTryBlock")
    @Transactional
    public void initDatabase() throws TestingServiceException {
        LOG.info("Initializing the database data.");

        try {

        } catch (Exception e) {
            throw new TestingServiceException(ErrorCode.TESTING_INIT_DATABASE_FAILED, "Failed to initialize the repositories.");
        }
    }

    @Transactional
    public void resetDatabase() throws TestingServiceException {
        LOG.info("Resetting the database.");
        wipeDatabase();
        initDatabase();
    }

    @Transactional
    public String echoResponse(@NotNull EchoRequest echoRequest) {
        return echoRequest.getMessage();
    }
}
