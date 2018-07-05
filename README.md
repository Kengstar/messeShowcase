# Anki Battle Showcase
ANKI Battle Showcase is a showcase racing game.
It offers a racing and a battle mode.
Its purpose is to integrate a to demonstrate.
For this we used Node-Red
Integrates custom bots and rulessets.

## Prerequisites
* JDK
* Node
* Maven
* Bluetooth Gateway (e.g. Raspbery pi) (if using real Anki Vehicles. see https://github.com/adessoAG/anki-drive-java)

## Installation
* Checkout this repository
* Run 'mvn install' in root directory
* Run 'npm install' in root directory
* Run 'npm install node-red-contrib-mqtt-broker' to install the MQTT broker
## Usage
* Run 'npm run node-red' to start the Node-Red server
* define rules for vehicles (see example flow for help)
* Configure Simulation in /src/main/java/de/adesso/anki/battle/initializers/SimulationInitializer.java
* Run Spring Boot Application


## Usage (Anki)
* Bluetooth gateway is necessary
*


## Modes
* Simulation
* Anki

## Supported Weapon Types
* Rocket
* Mine

## Disclaimer
The authors of this software are in no way affiliated to Anki. All naming rights for Anki, Anki Drive and Anki Overdrive are property of Anki.
