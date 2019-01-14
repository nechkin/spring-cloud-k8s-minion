# spring-cloud-k8s-minion

<code>mvn clean install

eval $(minikube docker-env)

mvn dockerfile:build

1. kubectl run minion --image=k8s-test/minion:1.0 --port=8080

2. kubectl expose deployment minion --type=NodePort

3. k expose deployment minion --name minion --type=NodePort --port=5005 --protocol=TCP

or

1. kubectl apply -f app-deployment.yaml

export NODE_PORT=$(kubectl get services/minion -o go-template='{{(index .spec.ports 0).nodePort}}')

curl $(minikube ip):$NODE_PORT
</code>
