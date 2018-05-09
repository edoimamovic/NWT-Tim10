# NWT-Tim10

## Docker
u svakom od root direktorija za mikroservise pokrenuti komandu:
```mvnw install dockerfile:build```

```dockerfile:push``` (mozda bude potrebno promijeniti property __docker.image.prefix__ u svoj DockerID) (ovaj se korak tehnicki ni ne mora uraditi :3)

Pokretanje DockerImage-a sa naredbom:

```docker run -p <port>:<port> -t <image.name>```
