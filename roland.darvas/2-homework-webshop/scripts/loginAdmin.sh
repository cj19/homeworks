curl --verbose --write-out '\n' --cookie cookie.txt --cookie-jar cookie.txt --data @darvasr.json --header "Content-Type: application/json" --request POST 'http://localhost:8080/ee2rolanddarvas-web/app/user/loginUser'