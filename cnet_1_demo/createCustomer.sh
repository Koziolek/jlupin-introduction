#!/usr/bin/env bash

curl -X POST "http://localhost:8082/customer/createCustomerService/createCustomer" -H "Accept: application/json" -H "Content-Type: application/json"  -H "X-JLNS-API-ID: RMC" -d "[\"$1\", \"$1\"]"
