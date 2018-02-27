module.exports = function(RED) {
    function RoadFacts(config) {
        RED.nodes.createNode(this,config);
        var node = this;
        node.on('input', function(msg) {
			// dirty, assumes theres only one fact right now
			if (msg.payload.nextRoadPiece[0] == "LeftCurveAhead"){
				var newMsg = {"fact": "Linkskurve"};
			}
			else if (msg.payload.nextRoadPiece[0] == "RightCurveAhead"){
				var newMsg = {"fact":"Rechtskurve"};
			}
			node.send(newMsg);
        });
    }
    RED.nodes.registerType("Streckenfakten",RoadFacts);
}