package com.soupthatisthick.dnd.utilities.server.service.testing;

import com.soupthatisthick.dnd.utilities.server.service.common.ErrorCode;
import com.soupthatisthick.dnd.utilities.server.service.testing.model.LogMessageRequest;
import com.soupthatisthick.dnd.utilities.server.service.testing.model.exception.TestingServiceException;
import com.soupthatisthick.dnd.utilities.server.util.json.JsonUtil;
import com.soupthatisthick.dnd.utilities.server.util.logger.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Owner on 9/9/2017.
 */
@Service
@Transactional(readOnly = true)
public class TestingService {

    @Transactional
    public void logMessageRequest(LogMessageRequest request) throws TestingServiceException {

        switch(request.getLogLevel()) {
            case INFO:
                Logger.info(JsonUtil.toJson(request, true));
                break;
            case DEBUG:
                Logger.debug(JsonUtil.toJson(request, true));
                break;
            case WARNING:
                Logger.warning(JsonUtil.toJson(request, true));
                break;
            case ERROR:
                Logger.error(JsonUtil.toJson(request, true), null);
                break;
            default:
                throw new TestingServiceException(ErrorCode.TESTING_LOG_LEVEL_REQUIRED, "Log level is required.");

        }

    }

    @Transactional
    public void cleanDatabase() throws TestingServiceException {
        Logger.info("Cleaning the database.");

        try {

        } catch (Exception e) {
            throw new TestingServiceException(ErrorCode.TESTING_WIPE_DATABASE_FAILED, "Failed to clean the repositories.");
        }
    }

    @Transactional
    public void initDatabase() throws TestingServiceException {
        Logger.info("Initializing the database data.");

        try {

        } catch (Exception e) {
            throw new TestingServiceException(ErrorCode.TESTING_INIT_DATABASE_FAILED, "Failed to initialize the repositories.");
        }
    }

    @Transactional
    public void resetDatabase() throws TestingServiceException {
        Logger.info("Resetting the database.");
        cleanDatabase();
        initDatabase();
    }
}
