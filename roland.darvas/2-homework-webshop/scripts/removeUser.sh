curl --verbose --write-out '\n' --cookie cookie.txt --cookie-jar cookie.txt --data @newUser.json --header "Content-Type: application/json" --request DELETE 'http://localhost:8080/ee2rolanddarvas-web/app/user/remove'
