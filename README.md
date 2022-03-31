#README


For local system:
Execution3.txt

Using docker-compose:
	
	COMMANDS:
	docker ps
	docker ps -a
	docker rm CONTAINER_ID
	docker images
	docker rmi IMAGE_ID
	docker-compose up
	
	EUREKA SERVER:
	http://localhost:8761/

	ZIPKIN: 
	http://localhost:9411/zipkin
	
	Through API Gateway:
	http://localhost:8765/manage-currency-conversion/USD
	http://localhost:8765/convert-currency-service/EUR/5/
