# spring-cloud-k8s-minion

<code>mvn clean install

mvn dockerfile:build

kubectl run minion --image=k8s-test/minion:1.0 --port=8080

kubectl expose deployment minion --type=NodePort

export NODE_PORT=$(kubectl get services/minion -o go-template='{{(index .spec.ports 0).nodePort}}')

curl $(minikube ip):$NODE_PORT
</code>
