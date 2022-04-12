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

#If deployment.yml is already created:
kubectl apply -f deployment.yaml

#KUBERNATES COMMANDS: STEP 1

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


#TO CREATE DEPLOYMENT FILE FROM THE AVAILABLE RUNNING CONFIGURATIONS: STEP 2

kubectl get deployment

kubectl get service

Note the name of both deployments and services. Will be used to get the yaml configuartions.

$ cd convertCurrency/

kubectl get deployment convert-currency -o yaml >> deployment.yaml

kubectl get service convert-currency -o yaml >> service.yaml

Copy the contents of service.yaml into deployment.yaml. Delete service.yaml

$ cd manageCurrencyConversion/

kubectl get deployment manage-currency-conversion -o yaml >> deployment.yaml

kubectl get service manage-currency-conversion -o yaml >> service.yaml

Copy the contents of service.yaml into deployment.yaml. Delete service.yaml

In deployment.yaml of manageCurrencyConversion change replicas value to 2

kubectl diff -f deployment.yaml - The difference b/w current configuartion and desired(changed) configuartion is shown.

kubectl apply -f deployment.yaml  - Here, kubernates compares the desired given configuartion with the currrent configuartion. 
									Add applies the necessary changes.

Ignore the warnings

kubectl get all

You will notice 2 pods of manage-currency-conversion is created


#DELETE all deployment, service, replicaset and pods
kubectl delete all -l app=DEPLOYMENT_NAME

kubectl delete all -l app=manage-currency-conversion

kubectl delete all -l app=convert-currency


#DIRECTLY CREATE DEPLOYMENT, PODS, replicaset & service using deployment.yaml: STEP 3

$ cd manageCurrencyConversion/

kubectl apply -f deployment.yaml

kubectl get all

cd convertCurrency/

kubectl apply -f deployment.yaml

kubectl get all


#Get logs of a pod
kubectl get pods

kubectl logs  pod/convert-currency-7fc8895b95-jsdqc

kubectl logs  -f pod/convert-currency-7fc8895b95-jsdqc

#ConfigMap
kubectl get configmap

kubectl create configmap currency-conversion --from-literal=MANAGE-CURRENCY-CONVERSION_URI=http://manage-currency-conversion

kubectl get configmap currency-conversion -o yaml

kubectl get configmap currency-conversion -o yaml >>  configmap.yaml

Copy the contents of configmap.yaml into deployment.yaml. Delete configmap.yaml

