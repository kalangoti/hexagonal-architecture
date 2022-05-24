# hexagonal-architecture-java
Arquitetura Hexagonal em Java

## Projeto Exemplo: Transferência bancária

### Protótipo:
![image](https://user-images.githubusercontent.com/12055277/160873087-ec7ea7d0-5e30-4b6a-99b7-2e4051359af8.png)

### Run local
```sh
cd desktop
./mvnw clean install
./mvnw javafx:run    
```

### Run .jar file
```sh
run maven clean install
open desktop
java --module-path="C:\projetos\javafx-sdk-11.0.2\lib" --add-modules=javafx.controls,javafx.fxml -jar target/desktop-1.0.0.jar 
```

### Run on IDE
`Run -> Edit Configurations` and add these VM options:
```sh
--module-path "\path\to\javafx-sdk-17.0.1\lib" --add-modules javafx.controls,javafx.fxml
```
