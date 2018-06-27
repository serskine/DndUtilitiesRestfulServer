package com.soupthatisthick.dnd.utilities.server.testing;

import com.soupthatisthick.dnd.utilities.server.encounter.entity.CrEntity;
import com.soupthatisthick.dnd.utilities.server.encounter.entity.XpThresholdEntity;
import com.soupthatisthick.dnd.utilities.server.common.model.ErrorCode;
import com.soupthatisthick.dnd.utilities.server.encounter.repo.*;
import com.soupthatisthick.dnd.utilities.server.testing.model.EchoRequest;
import com.soupthatisthick.dnd.utilities.server.testing.model.LogMessageRequest;
import com.soupthatisthick.dnd.utilities.server.testing.model.exception.TestingServiceException;
import com.soupthatisthick.dnd.utilities.server.util.text.Text;
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
    @Autowired
    private CrRepository crRepository;

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
            crRepository.deleteAllInBatch();
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
            initChallengeRatings();
        } catch (Exception e) {
            throw new TestingServiceException(ErrorCode.TESTING_INIT_DATABASE_FAILED, "Failed to initialize the repositories. " + e.getMessage(), e);
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


    public void initChallengeRatings() {
        LOG.info("Initializing challenge ratings.");
        final String[][] table = new String[][] {
                {"0", "0"},
                {"1", "0"},
                {"2", "0"},
                {"3", "0"},
                {"4", "0"},
                {"5", "0"},
                {"6", "0"},
                {"7", "0"},
                {"8", "0"},
                {"9", "0"},
                {"10", "0"},
                {"11", "0"},
                {"12", "0"},
                {"13", "0"},
                {"14", "0"},
                {"15", "0"},
                {"16", "0"},
                {"17", "0"},
                {"18", "0"},
                {"19", "0"},
                {"20", "0"},
                {"21", "0"},
                {"22", "0"},
                {"23", "0"},
                {"24", "0"},
                {"25", "0"},
                {"26", "0"},
                {"27", "0"},
                {"28", "0"},
                {"29", "0"},
        };

        String tableString = Text.tableString(table, "cr", "xp");
        StringBuilder sb = new StringBuilder();
        sb.append(tableString);

        for(int i=0; i<table.length; i++) {
            CrEntity entity = new CrEntity(
                    Float.parseFloat(table[i][0]),
                    Integer.parseInt(table[i][1])
            );
            CrEntity savedEntity = crRepository.save(entity);
        }

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
