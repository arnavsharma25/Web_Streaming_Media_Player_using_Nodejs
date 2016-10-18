var http = require("http"),
    url = require("url"),
    path = require("path"),
    fs = require("fs"),
    mime = require("mime"),
    sockjs = require("sockjs");

var wd = process.argv[2] || process.cwd(),
    staticPort = 8080,
    dirPort = 8081,
    playerPort = 3000,
    remotePort = 3001;

http.createServer(function(request, response) {
    var origin = (request.headers.origin || "*");

    if (request.method.toUpperCase() === "OPTIONS") {
        response.writeHead("204", "No Content", {
            "access-control-allow-origin": origin,
            "access-control-allow-methods": "GET, POST, PUT, DELETE, OPTIONS",
            "access-control-allow-headers": "content-type, accept",
            "access-control-max-age": 10,
            "content-length": 0
        });

        return response.end();
    }

    var requestBodyBuffer = [];

    request.on("data", function(chunk) {
        requestBodyBuffer.push( chunk );
    });

    request.on("end", function() {
        var requestBody = requestBodyBuffer.join( "" );
        var responseBody = fs.readdirSync("player/videos").toString();

        response.writeHead("200", "OK", {
            "access-control-allow-origin": origin,
            "content-type": "text/plain",
            "content-length": responseBody.length
        });

        return response.end(responseBody);
    });
}).listen(dirPort);

function staticServe(request, response) {
    var uri = url.parse(request.url).pathname;

    if (uri === "/")
        uri = "/player";

    var filename = path.join(wd, uri);

    console.log(filename);

    fs.exists(filename, function(exists) {
        if (!exists) {
            fs.readFile("404.htm", function(err, contents) {
                if (!err) {
                    response.writeHead(404, {'Content-Type': 'text/html'});
                    response.end(contents);
                }
            });
            return;
        }

        if (fs.statSync(filename).isDirectory())
            filename += '/index.html';

        mimetype = mime.lookup(filename);

        fs.readFile(filename, "binary", function(err, file) {
            if (err) {
                response.writeHead(500, {"Content-Type": "text/plain"});
                response.write(err + "\n");
                response.end();
                return;
            }

            response.writeHead(200, {"Content-Type": mimetype});
            response.write(file, "binary");
            response.end();
        });
    });
}

var staticServer = http.createServer(staticServe).listen(staticPort),
    playerServer = http.createServer().listen(playerPort),
    remoteServer = http.createServer().listen(remotePort);

var playerSocket = sockjs.createServer(),
    remoteSocket = sockjs.createServer();

var playerConnection = null;

playerSocket.on('connection', function(conn) {
    console.log("Player connected.");
    playerConnection = conn;

    conn.on('close', function() {
        console.log("Player diconnected.");
    });
});

remoteSocket.on('connection', function(conn) {
    console.log("Remote connected.");

    conn.on('data', function(message) {
        playerConnection.write(message);
    });

    conn.on('close', function() {
        console.log("Remote diconnected.");
    });
});

playerSocket.installHandlers(playerServer);
remoteSocket.installHandlers(remoteServer);

console.log("Servers running\n");
