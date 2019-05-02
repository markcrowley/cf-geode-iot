package com.ganture.cfgeodeiot.service;

import java.util.List;
import java.util.Map;
import com.ganture.cfgeodeiot.domain.SensorValue;
import com.ganture.cfgeodeiot.domain.Stats;
import com.ganture.cfgeodeiot.exception.LicenceException;
import com.google.common.collect.EvictingQueue;

/**
 * Ingress service
 * 
 * @author <a href="mailto:markcrowley@gmail.com">Mark Crowley</a>
 */
public interface IngressService {

  public Map<String, Integer> ingress(List<SensorValue> sensorValues);

  public EvictingQueue<SensorValue> list(String deviceId) throws LicenceException;

  public Stats stats();
}
