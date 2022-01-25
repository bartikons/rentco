# rentco

Example to get room Reservation 
curl http://localhost:8080/api/RoomReservation?roomId=1

Example to get tenant 
curl http://localhost:8080/api/TenantReservation?tenantName=DORI6

Example to create reservation 
  curl -X POST http://localhost:8080/api/RoomReservation   
    -H 'Content-Type: application/json'  
    -d '{\"price\":"4000",\"tenantId\":"4",\"landlordId\":"1",\"dateFrom\":\"2021-12-01\",\"dateTo\":\"2021-12-23\",\"rentroomId\":"6"}'

Example to change reservation


curl -X PUT http://localhost:8080/api/RoomReservation
    -H 'Content-Type: application/json'
    -d '{\"id\":1,\"price\":"4000",\"tenantId\":"4",\"landlordId\":"1",\"dateFrom\":\"2021-12-01\",\"dateTo\":\"2021-12-23\",\"rentroomId\":"6"}'
