#README

#DOCKER IMAGE CREATION COMMANDS:  
Create the images needed in docker-compose file using STS build-image command or using docker build command.

#Docker BUILD COMMAND:

docker build -t deancha12/convert-currency-service-kubernates:0.0.11-SNAPSHOT .
docker images
docker build -t deancha12/manage-currency-conversion-kubernates:0.0.11-SNAPSHOT .
docker images

#DOCKER IMAGE PUSH TO REGISTER HUB COMMAND:

docker push deancha12/manage-currency-conversion-kubernates:0.0.11-SNAPSHOT
docker push deancha12/convert-currency-service-kubernates:0.0.11-SNAPSHOT

#KUBERNATES COMMANDS:

kubectl version

kubectl create deployment manage-currency-conversion --image=deancha12/manage-currency-conversion-kubernates:0.0.11-SNAPSHOT
kubectl expose deployment manage-currency-conversion --type=LoadBalancer --port=8000

kubectl get pods
kubectl get replicaset
kubectl get deployment
kubectl get service
kubectl get all

kubectl create deployment convert-currency --image=deancha12/convert-currency-service-kubernates:0.0.11-SNAPSHOT
kubectl expose deployment convert-currency --type=LoadBalancer --port=8100

kubectl get pods
kubectl get replicaset
kubectl get deployment
kubectl get service
kubectl get all
