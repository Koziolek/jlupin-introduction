#!/usr/bin/env bash

curl -X POST "http://localhost:8082/order/createOrderService/createOrder" -H "Accept: application/json" -H "Content-Type: application/json"  -H "X-JLNS-API-ID: RMC" -d "[\"$1\", \"$2\"]"
