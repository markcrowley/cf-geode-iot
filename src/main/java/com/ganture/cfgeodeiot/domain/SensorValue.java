package com.ganture.cfgeodeiot.domain;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * Sensor value
 * 
 * @author <a href="mailto:markcrowley@gmail.com">Mark Crowley</a>
 */
@Data
public class SensorValue {

  private LocalDateTime timestamp;

  private String deviceId;

  private double x;

  private double y;

  private double z;

  /*
   * Additional properties to be added
   */
}
