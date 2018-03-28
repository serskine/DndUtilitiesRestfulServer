package com.soupthatisthick.dnd.utilities.server.service.testing;

import com.soupthatisthick.dnd.utilities.server.data.jpa.entity.encounter.measure.XpThresholdEntity;
import com.soupthatisthick.dnd.utilities.server.data.jpa.repository.AllyRepository;
import com.soupthatisthick.dnd.utilities.server.data.jpa.repository.EncounterRepository;
import com.soupthatisthick.dnd.utilities.server.data.jpa.repository.EnemyRepository;
import com.soupthatisthick.dnd.utilities.server.data.jpa.repository.XpThresholdRepository;
import com.soupthatisthick.dnd.utilities.server.service.common.base.ErrorCode;
import com.soupthatisthick.dnd.utilities.server.service.testing.model.EchoRequest;
import com.soupthatisthick.dnd.utilities.server.service.testing.model.LogMessageRequest;
import com.soupthatisthick.dnd.utilities.server.service.testing.model.exception.TestingServiceException;
import com.soupthatisthick.dnd.utilities.server.util.json.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
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
    @Autowired
    private XpThresholdRepository xpThresholdRepository;

	@PostConstruct
    @Transactional
	public void init() {
		LOG.info("Initializing Testing Service with test data");
		try {
			initDatabase();
		} catch (Exception e) {
			LOG.warning("Failed to initialize the testing service properly. " + e.getMessage(), e);
		}
	}

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
            xpThresholdRepository.deleteAllInBatch();
        } catch (Exception e) {
            throw new TestingServiceException(ErrorCode.TESTING_WIPE_DATABASE_FAILED, "Failed to clean the repositories.");
        }
    }

    @SuppressWarnings("EmptyTryBlock")
    @Transactional
    public void initDatabase() throws TestingServiceException {
        LOG.info("Initializing the database data.");

        try {
            initXpThresholds();
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

    /**
     * This will initialize all the xp thresholds for levels 1-20
     */
    @Transactional
    public void initXpThresholds() {
        LOG.info("Initializing xp thresholds.");
        final Integer[][] table = new Integer[][] {
                {1, 25, 50, 75, 100},
                {2, 50, 100, 150, 200},
                {3, 75, 150, 225, 400},
                {4, 125, 250, 375, 500},
                {5, 250, 500, 750, 1100},
                {6, 300, 600, 900, 1400},
                {7, 350, 750, 1100, 1700},
                {8, 450, 900, 1400, 2100},
                {9, 550, 1100, 1600, 2400},
                {10, 600, 1200, 1900, 2800},
                {11, 800, 1600, 2400, 3600},
                {12, 1000, 2000, 3000, 4500},
                {13, 1100, 2200, 3400, 5100},
                {14, 1250, 2500, 3800, 5700},
                {15, 1400, 2800, 4300, 6400},
                {16, 1600, 3200, 4800, 7200},
                {17, 2000, 3900, 5900, 8800},
                {18, 2100, 4200, 6300, 9500},
                {19, 2400, 4900, 7300, 10900},
                {20, 2800, 5700, 8500, 12700}
        };

        StringBuilder sb = new StringBuilder();
        final String header = String.format(" - %7s, %7s, %7s, %7s, %7s\n",
                "level",
                "easy",
                "normal",
                "hard",
                "deadly"
        );
        sb.append("\n");
        sb.append(header);

        for(int i=0; i<table.length; i++) {
            XpThresholdEntity entity = new XpThresholdEntity(
              table[i][0],
              table[i][1],
              table[i][2],
              table[i][3],
              table[i][4]
            );
            XpThresholdEntity savedEntity = xpThresholdRepository.save(entity);
            final String line = String.format(" - %7d, %7d, %7d, %7d, %7d\n",
                    savedEntity.getLevel(),
                    savedEntity.getEasy(),
                    savedEntity.getModerate(),
                    savedEntity.getHard(),
                    savedEntity.getDeadly()
            );
            sb.append(line);
        }

        LOG.info(sb.toString());
    }
}
