package com.ganture.cfgeodeiot.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import com.ganture.cfgeodeiot.domain.SensorValue;
import com.ganture.cfgeodeiot.domain.Stats;
import com.ganture.cfgeodeiot.exception.LicenceException;
import com.google.common.collect.EvictingQueue;
import org.springframework.stereotype.Service;

/**
 * Ingress service implementation
 * 
 * @author <a href="mailto:markcrowley@gmail.com">Mark Crowley</a>
 */
@Service
public class IngressServiceImpl implements IngressService {

  /*
   * In-memory database.
   * 
   * Map keyed on deviceId where the value is an evicting queues of sensor values for the device
   */
  private static Map<String, EvictingQueue<SensorValue>> sensorValues = new HashMap<>();

  private static final EvictingQueue<SensorValue> emptyQueue = EvictingQueue.create(0);

  public Map<String, Integer> ingress(List<SensorValue> ingressValues) throws LicenceException {
    if (sensorValues.keySet().size() > 100) {
      throw new LicenceException("Your device limit has been reached");
    }
    for (SensorValue value : ingressValues) {
      if (!sensorValues.containsKey(value.getDeviceId())) {
        EvictingQueue<SensorValue> evictingQueue = EvictingQueue.create(1000);
        evictingQueue.add(value);
        sensorValues.put(value.getDeviceId(), evictingQueue);
      } else {
        sensorValues.get(value.getDeviceId()).add(value);
      }
    }
    Map<String, Integer> response = new HashMap<>();
    response.put("ack-count", ingressValues.size());
    return response;
  }

  public EvictingQueue<SensorValue> list(String deviceId) {
    if (!sensorValues.containsKey(deviceId)) {
      return emptyQueue;
    }
    return sensorValues.get(deviceId);
  }

  public Stats stats(String deviceId) {
    Stats stats = new Stats();
    stats.setDeviceId(deviceId);
    stats.setGenerated(LocalDateTime.now());
    stats.setCount(new Long(null != IngressServiceImpl.sensorValues.get(deviceId)
        ? IngressServiceImpl.sensorValues.get(deviceId).size()
        : 0L));
    Random random = new Random();
    stats.setX(random.nextDouble());
    stats.setY(random.nextDouble());
    stats.setZ(random.nextDouble());
    return stats;
  }
}
