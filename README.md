# springboot-azure-sql-workflow-identity
Example of springboot app using Azure sql with workload identity, hopefully useful for debugging.

Managed identity authentication works locally and using Azure (workload identity and others)

For local testing, azd cli needs to be installed and logged in to Azure.

Expects environment variables:
`DB_NAME` - name of the database (In Azure)

Exposes a endpoint `/test` that should return something from DB. If you get errors, then your workflow identity is probably not set up correctly.
Logs SQL statements and other things, check logs...