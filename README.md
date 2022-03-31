#README


For local system:
Execution3.txt

Using docker-compose:
	
	IMAGE CREATION COMMANDS:  Create the images needed in docker-compose file using STS build-image command or using docker build command.
	Docker build command:
	docker build -t deancha12/convert-currency-service-kubernates:0.0.11-SNAPSHOT . 
	docker images 
	docker build -t deancha12/manage-currency-conversion-kubernates:0.0.11-SNAPSHOT .

	
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
