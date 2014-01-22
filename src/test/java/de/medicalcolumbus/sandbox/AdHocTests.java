package de.medicalcolumbus.sandbox;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * Created by chromyd on 21/01/14.
 */
public class AdHocTests {
	private static Logger log = LoggerFactory.getLogger(AdHocTests.class);

	@Test
    public void generateUuid() {
        log.info("My UUID: {}", UUID.randomUUID());
    }
}
