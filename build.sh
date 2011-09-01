lein uberjar && cp rock*standalone*.jar up && zip team2.zip -r up && curl http://172.6.0.249:3000/players --header 'Content-Type: application/octet-stream' --data-binary @team2.zip
