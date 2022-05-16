# hubble-data
The service-layer for the KPMP Atlas Spatial Viewer

## Building with gradle
`$ ./gradlew build`

This will result in a build folder with the jarfile at ./build/libs/hubble-data.jar

## Building The Dockerfile
The docker file requires the jar file be extracted to the target/dependency folder in order to build properly
`$ cd target/dependency && jar -xf ../../build/libs/hubble-data.jar && cd ../../`

You should now be able to build docker with:

`$ docker build .`