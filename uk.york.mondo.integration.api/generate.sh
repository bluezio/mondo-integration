#!/bin/bash

rm -rf src-gen
mkdir src-gen
thrift -out src-gen --gen java src/api.thrift
