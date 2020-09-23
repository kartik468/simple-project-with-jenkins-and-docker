### Steps

```sh
# run jmeter
cd <project root folder>

# run backend
cd server
java -jar target/notes.jar

# run ui
cd client/public-html
http-server -p 8082

# opetn 'localhost:8082' to see UI

# run jmeter script
# FirstTest_updated.jmx this is updated jmx file contains jmeter-prometheus plugin configuration 
jmeter -n -t FirstTest_updated.jmx -l log\first_test_updated_log1.jtl
```
### APIs

```js
// get notes
fetch("http://localhost:8081/note/", {
  "headers": {
    "accept": "*/*",
    "accept-language": "en-US,en;q=0.9",
    "content-type": "application/json",
    "sec-fetch-dest": "empty",
    "sec-fetch-mode": "cors",
    "sec-fetch-site": "same-site"
  },
  "referrer": "http://localhost:8082/",
  "referrerPolicy": "no-referrer-when-downgrade",
  "body": null,
  "method": "GET",
  "mode": "cors"
});

// create note
fetch("http://localhost:8081/note/", {
  "headers": {
    "accept": "*/*",
    "accept-language": "en-US,en;q=0.9",
    "content-type": "application/json",
    "sec-fetch-dest": "empty",
    "sec-fetch-mode": "cors",
    "sec-fetch-site": "same-site"
  },
  "referrer": "http://localhost:8082/",
  "referrerPolicy": "no-referrer-when-downgrade",
  "body": "{\"text\":\"note 1\"}",
  "method": "POST",
  "mode": "cors"
});

```

---
### References

https://www.youtube.com/watch?v=pZ0SfFv0qFE&ab_channel=QAInsights-NaveenKumarNamachivayam

https://dev.to/qainsights/jmeter-prometheus-and-grafana-integration-312n

https://github.com/johrstrom/jmeter-prometheus-plugin

---

jenkins path

http://localhost:8083/