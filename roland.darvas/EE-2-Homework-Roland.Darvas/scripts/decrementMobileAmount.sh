mobileId=$(sed "s/^.*\"id\"\s*:\s*\"\(.\{36\}\)\".*$/\1/" exampleMobileTypeGet.json)

curl --verbose --write-out '\n' --cookie cookie.txt --data '5' --header 'Content-Type: application/json' --cookie-jar cookie.txt --request PUT "http://localhost:8080/ee2rolanddarvas-web/app/inventory/remove/$mobileId"
