How to run the application

Using dockerhub
1) pull docker images from dockerhub https://hub.docker.com/repository/docker/austinmazw/dockerhub
2) download the repository files in github
3) within fib folder, run commandline docker-compose up

Using dockerfile
1) built docker images for springboot and mongo. E.g. docker build -t NAMEOFREPO:TAG
2) run mongo image. E.g. docker run -d -p 27017:27017 --name NAMEHERE mongo:latest
3) run springboot image and link with mongo. E.g. docker run-p 8080:8080 --name IMAGENAME --link MONGONAME -d REFERENCENAME

Access to remote public IP
http://158.101.147.13:8080/fibonacci
