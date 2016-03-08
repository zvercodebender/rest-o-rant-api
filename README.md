# To build

1. Install Java 8.
1. Modify the `url` and `certPath` properties in the `docker` section of the `build.gradle` file to point to your Docker machine.
1. Build the image with: `./gradlew clean buildDockerImage`
  * If you want to override the version of the image built, use: `./gradlew -Pversion=_VERSION_ clean buildDockerImage`

# To run

1. Run the Docker image built in the previous step by executing: `docker run -dP --name rest-o-rant-api dkr-reg:5000/rest-o-rant-api:v1`

# To access

1. Check the port at which port 80 is exposed by running `docker ps`.
1. Open `http://<DOCKER>:<PORT>/`.
1. See the restaurant main page.
1. Click the Search button.
