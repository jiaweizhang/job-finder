#!/bin/bash

# Direct psql populate
psql -h localhost -d jf -U postgres -f setup.sql

# do this to dump the database to file
# pg_dump rp -U postgres -h localhost -F c --file=ev1.sql
