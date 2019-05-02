# Cloud Foundry, Apache Geode, IoT scratch project

Simple REST API to ingress sensor readings from an IoT gateway and store in Apache Geode.

The API provide the following end-points:

1. `POST` `/v1/ingress`
2. `GET` `/v1/values/{deviceId}`
3. `GET` `/v1/stats`

See … for the API documentation