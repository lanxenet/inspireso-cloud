@curl http://192.168.8.104:9999/service/stop/configsvc
@curl -v -F "target=E:/inspireso/bin/config/bootstrap.jar" -F "file=@E:/home/Github/inspireso-micservice/inspireso-confg-service/target/bootstrap.jar" http://192.168.8.104:9999/deploy
@curl http://192.168.8.104:9999/service/start/configsvc
