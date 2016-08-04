curl --verbose --write-out '\n' --cookie cookie.txt --cookie-jar cookie.txt --data @newMobile.json --header "Content-Type: application/json" --request POST 'http://localhost:8080/ee2rolanddarvas-web/app/mobiles' > newMobile.json
#Néha nem működik a script, ki tudja miért. restes böngészős tesztnél mindig működik
