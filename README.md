# spring-cloud-k8s-minion

<h3>Spring Kubernetes discovery</h3>

```
mvn clean install
eval $(minikube docker-env)
mvn dockerfile:build

1. kubectl run minion --image=k8s-test/minion:1.0 --port=8080
2. kubectl expose deployment minion --type=NodePort
3. k expose deployment minion --name minion --type=NodePort --port=5005 --protocol=TCP

or

1. kubectl apply -f app-deployment.yaml

export NODE_PORT=$(kubectl get services/minion -o go-template='{{(index .spec.ports 0).nodePort}}')
curl $(minikube ip):$NODE_PORT
```

<h3>Eureka</h3>
Run eureka server 

```
cd eureka-server
mvn clean install
mvn spring-boot:run
cd ..
```

Run minion with eureka client

```
mvn clean install -P 'eureka,!kubernetes'
mvn spring-boot:run
```
