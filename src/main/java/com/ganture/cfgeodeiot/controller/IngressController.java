package com.ganture.cfgeodeiot.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import java.util.List;
import com.ganture.cfgeodeiot.domain.SensorValue;
import com.ganture.cfgeodeiot.service.IngressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Ingress controller
 * 
 * @author <a href="mailto:markcrowley@gmail.com">Mark Crowley</a>
 */
@RestController
public class IngressController {

  @Autowired
  IngressService ingressService;

  @RequestMapping(value = "/v1/ingress", method = RequestMethod.POST,
      produces = APPLICATION_JSON_VALUE)
  public ResponseEntity ingress(@RequestBody List<SensorValue> sensorValues) {
    return ResponseEntity.ok().body(ingressService.ingress(sensorValues));
  }

  @RequestMapping(value = "/v1/values/{deviceId}", method = RequestMethod.GET,
      produces = APPLICATION_JSON_VALUE)
  public ResponseEntity list(@PathVariable("deviceId") String deviceId) {
    return ResponseEntity.ok().body(ingressService.list(deviceId));
  }

  @RequestMapping(value = "/v1/stats", method = RequestMethod.GET,
      produces = APPLICATION_JSON_VALUE)
  public ResponseEntity stats() {
    return ResponseEntity.ok().body(ingressService.stats());
  }
}
