package cs3500.test;

import com.fasterxml.jackson.databind.JsonNode;
import cs3500.pa05.model.EventJson;
import cs3500.pa05.model.JsonUtils;
import cs3500.pa05.model.TimeJson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Class that contains the methods for testing JsonUtils.
 */
public class JsonUtilsTest {
  @Test
  public void testSerializeRecord() {
    Record record = new TimeJson(10, 20);
    JsonNode node = JsonUtils.serializeRecord(record);

    // Verify that the returned JsonNode is not null
    Assertions.assertNotNull(node);
  }

  @Test
  public void testSerializeRecord2() {
    Record record = new EventJson(
        "Test on Monday",
        "Study for the test on Monday",
        "Monday",
        new TimeJson(10, 20),
        30);
    JsonNode node = JsonUtils.serializeRecord(record);

    // Verify that the returned JsonNode is not null
    Assertions.assertNotNull(node);
  }
}
