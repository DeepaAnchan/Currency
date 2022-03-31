#README

#DOCKER:
docker ps
docker ps -a
docker rm CONTAINER_ID
docker images
docker rmi IMAGE_ID
docker-compose up

#KUBERNATES

	#Deploys an image to a kubernates cluster - Creates a deployment, replicaset and pod
	kubectl create deployment PROJECT_NAME --image=IMAGE_NAME:VERSION

	kubectl create deployment hello-world-rest-api --image=in28min/hello-world-rest-api:0.0.1.RELEASE

	#Expose deployment to the outside world-rest-api as a load balancer on port 8080 - Creates a service
	kubectl expose deployment hello-world-rest-api --type=LoadBalancer --port=8080


	#URI
	/hello-world
	/hello-world-bean

	#List all events that occured
	kubectl get events

	#Shows all the pods, deployment, replicaset and service that were created
	kubectl get pods
	kubectl get replicaset
	kubectl get deployment
	kubectl get service


	#PODS
		kubectl get pods
		#For more details:
		kubectl get pods -o wide

		kubectl explain pods

		#Gives all the details related to the pod
		kubectl describe pod_name

		#To delete a pod
		kubectl delete pods pod_name
		
	#REPLICASET - It's like a config file. Ensures a specific no. of pods are always running. 
	#Always monitors the pods.If no.  of pods is less than the desired then, 
	#creates a new pod to get the desired no.
		kubectl get replicaset
		kubectl get rs
		
		#For more details:
		kubectl get rs -o wide

		#Used to create 'n' no. of replicaset
		kubectl scale deployment hello-world-rest-api --replicaset=3
		kubectl get pods
		kubectl get replicaset
		kubectl get events
		
		kubectl explain replicaset

	#Deployment: Ensures switch from 1 version pod to another happens seamlessly. 
	#Prevents downtimes on releasing the new versions of the app.
		
		#If u want to deploy a new version of the micro-service then, - On executing this, 
		#pods with old image will terminate parallely new pods with new image will take their place.
		#Rolling update strategy is used here.- 1 pod at a time is deleted(old pod) parallely a new 
		#pod is created.
		kubectl set image deployment NAME_OF_THE_DEPLOYMENT NAME+OF_THE_CONTAINER=IMAGE_NAME:VERSION
		kubectl set image deployment hello-world-rest-api hello-world-rest-api=DUMMY_IMAGE:VERSION

		kubectl get rs -o wide
		
		kubectl get pods
		kubectl describe pod pod_name
		kubectl get events
		
	#Service - Allows the application to receive request through a permanent unchanging interface. 
	#IP address of the service is used to access pods.
	
		#Every time a pod is deleted, because of replicaset a new pod will be created to maintain the no. of 
		#pods to be running with a "NEW IP ADDRESS".
		kubectl get pods -o wide
		kubectl delete pod pod_name
		kubectl get pods -o wide
	
		#PODS are always getting created/deleted. 
		#To provide 1 common external interface to the user so as to not be affected by changing pods,
		#"service" is used.
		
		#LoadBalancer - Takes not of all changing pods & makes sure to distribute the request amongst the 
		#working pods.
		
		kubectl get services
		
		#A clusterIP service can only be accessed inside a cluster. No external IP present for this service.
		#A node IP service is also present.
		
	
	
	
	#To check on master nodes
	kubectl get componentstatuses