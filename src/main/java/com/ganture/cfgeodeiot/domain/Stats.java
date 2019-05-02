package com.ganture.cfgeodeiot.domain;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Stats {

  LocalDateTime generated;

  Long count;

  Double x;

  Double y;

  Double z;

  /*
   * Additional statistics to be added
   */
}
