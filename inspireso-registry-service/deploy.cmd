@curl http://192.168.8.104:9999/service/stop/registrysvc
@curl -v -F "target=E:/inspireso/bin/registry/bootstrap.jar" -F "file=@E:/home/Github/inspireso-micservice/inspireso-registry-service/target/bootstrap.jar" http://192.168.8.104:9999/deploy
@curl http://192.168.8.104:9999/service/start/registrysvc
