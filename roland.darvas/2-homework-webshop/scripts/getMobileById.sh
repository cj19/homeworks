mobileId=$(sed "s/^.*\"id\"\s*:\s*\"\(.\{36\}\)\".*$/\1/" newMobile.json)
curl --verbose --write-out '\n' --cookie cookie.txt --cookie-jar cookie.txt --request GET "http://localhost:8080/ee2rolanddarvas-web/app/mobile/get/$mobileId"
