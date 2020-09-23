
```sh
# run jmeter
jmeter -n -t examples\kartik\FirstTest.jmx -l examples\kartik\first_test_result.jtl

jmeter -n -t FirstTest.jmx -l logs\first_test_result.jtl

jmeter -n -t FirstTest_updated.jmx -l log\first_test_updated_log1.jtl



# run backend
cd server
java -jar target/notes.jar

# apis
# get notes : [TO DO]

# run ui
cd client/public-html
http-server -p 8082

# localhost:8082
```

https://www.youtube.com/watch?v=pZ0SfFv0qFE&ab_channel=QAInsights-NaveenKumarNamachivayam

https://dev.to/qainsights/jmeter-prometheus-and-grafana-integration-312n

https://github.com/johrstrom/jmeter-prometheus-plugin

---

jenkins path

http://localhost:8083/